package cn.easybuy.web.pre;

import cn.easybuy.pojo.User;
import cn.easybuy.service.user.UserService;
import cn.easybuy.service.user.UserServiceImpl;
import cn.easybuy.utils.*;
import cn.easybuy.web.AbstractServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/Register"}, name = "Register")
public class RegisterServlet extends AbstractServlet {

    private UserService userService;
    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }
    public Class getServletClass(){
        return RegisterServlet.class;
    }

    // 跳转到注册界面
    public String toRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        return "/pre/register";
    }

    public ReturnResult doRegister(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ReturnResult result = new ReturnResult();
        User user = new User();
        String loginName = request.getParameter("loginName");
        User preUser = userService.getUserByLoginName(loginName); //与之前名字进行对比
        //判断用户是否存在
        if (EmptyUtils.isNotEmpty(preUser)){
            result.returnFail("用户已经存在！");
            return result;
        }
        String sex = request.getParameter("sex");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String identityCode = request.getParameter("identityCode");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        user.setLoginName(loginName);
        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(SecurityUtils.md5Hex(password)); //MD5加密
        user.setSex(EmptyUtils.isEmpty(sex)?1:0); //进行性别的判断
        user.setIdentityCode(identityCode);
        user.setMobile(mobile);
        user.setType(Constants.UserType.PRE);
        result = checkUser(user);

        //判断是否验证通过
        if (result.getStatus() == Constants.ReturnResult.SUCCESS){
            boolean flag = userService.save(user);
            if (!flag){
                return result.returnFail("注册失败！");
            }else {
                return result.returnSuccess("注册成功！");
            }
        }
        else {
            return result;
        }

    }

    // 验证注册信息，使用正则表达式
    public ReturnResult checkUser(User user){
        ReturnResult result = new ReturnResult();

        // 手机号码
        if (EmptyUtils.isNotEmpty(user.getMobile())){
            if (!RegUtils.checkMobile(user.getMobile())){
                return result.returnFail("请输入正确手机号码!");
            }
        }
        // 邮箱
        if (EmptyUtils.isNotEmpty(user.getEmail())){
            if (!RegUtils.checkMobile(user.getEmail())){
                return result.returnFail("请输入正确邮箱!");
            }
        }

        // 身份证
        if (EmptyUtils.isNotEmpty(user.getEmail())){
            if (!RegUtils.checkMobile(user.getEmail())){
                return result.returnFail("请输入正确身份证号!");
            }

        }
        return result;
    }


}
