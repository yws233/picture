package cn.easybuy.web.pre;

import cn.easybuy.pojo.ProductCategory;
import cn.easybuy.service.product.ProductCatrgoryService;
import cn.easybuy.service.product.ProductCatrgoryServiceImpl;
import cn.easybuy.web.AbstractServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 处理首页中的请求,使用反射技术实现，继承至AbstrctServlet
 * @author natural
 */
@WebServlet(urlPatterns = {"/Home"},name = "Home")
public class HomeServlet extends AbstractServlet {

    //初始实例化
    private ProductCatrgoryService productCatrgoryService;
    public void init() throws ServletException{
        productCatrgoryService = new ProductCatrgoryServiceImpl();
    }
    /*@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 调用service层，查询数据
        productCatrgoryService = new ProductCatrgoryServiceImpl();
        List<ProductCategory> productCategoryList = productCatrgoryService.queryAllProductCategory("0");
        req.setAttribute("pcList",productCategoryList);
        req.getRequestDispatcher("/pre/index.jsp").forward(req,resp);
    }*/

    public String index(HttpServletRequest request,HttpServletResponse response) throws Exception{
        List<ProductCategory> productCategoryList = productCatrgoryService.queryAllProductCategory("0");
        request.setAttribute("pcList",productCategoryList);

        return "/pre/index";  //在抽象类进行了拼接
    }

    @Override
    public Class getServletClass() {
        return HomeServlet.class;
    }
}
