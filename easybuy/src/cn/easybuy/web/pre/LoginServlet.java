package cn.easybuy.web.pre;

import cn.easybuy.pojo.User;
import cn.easybuy.service.user.UserService;
import cn.easybuy.service.user.UserServiceImpl;
import cn.easybuy.utils.EmptyUtils;
import cn.easybuy.utils.ReturnResult;
import cn.easybuy.utils.SecurityUtils;
import cn.easybuy.web.AbstractServlet;
import com.sun.org.apache.regexp.internal.RE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Login"}, name = "Login")
public class LoginServlet extends AbstractServlet{
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    public Class getServletClass() {
        return LoginServlet.class;
    }
    /*
    * 跳转到登录页面
    * */
    public String toLogin(HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("进入login......");
        return "/pre/login";
    }

    public ReturnResult login(HttpServletResponse response,HttpServletRequest request){
        ReturnResult result=new ReturnResult();
        //参数获取
        String loginName=request.getParameter("loginName");
        String password=request.getParameter("password");
        User user=userService.getUserByLoginName(loginName);
        if(EmptyUtils.isEmpty(user)){
            result.returnFail("用户不存在");
        }else{
            if(user.getPassword().equals(SecurityUtils.md5Hex(password))){

                System.out.println(">>>>>>>>>判断方法》》》》》》》》》");
                //登陆成功
                request.getSession().setAttribute("loginUser", user);
                result.returnSuccess("登陆成功");
            }else{
                result.returnFail("密码错误");
            }
        }
        return result;
    }

    public String loginOut(HttpServletRequest request,HttpServletResponse response) throws Exception{
        ReturnResult result = new ReturnResult();
        request.getSession().removeAttribute("loginUser");
        result.returnSuccess("注销成功！");
        return "/pre/login";
    }
}
