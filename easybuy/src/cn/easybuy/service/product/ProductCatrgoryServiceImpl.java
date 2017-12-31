package cn.easybuy.service.product;

import cn.easybuy.dao.product.ProductCategoryDao;
import cn.easybuy.dao.product.ProductCategoryDaoImpl;
import cn.easybuy.pojo.ProductCategory;
import cn.easybuy.utils.DataSourceUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductCatrgoryServiceImpl implements ProductCatrgoryService {

    private Connection connection;
    private ProductCategoryDao productCategoryDao;
    @Override
    public List<ProductCategory> queryAllProductCategory(String parentId) {
        List<ProductCategory> productCategoryList = new ArrayList<>();
        try {
            connection = DataSourceUtil.openConnection();
            productCategoryDao = new ProductCategoryDaoImpl(connection);
            if (null == parentId || "".equals(parentId)){
                parentId = "0";
            }
            productCategoryList = productCategoryDao.queryAllProductCategory(parentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DataSourceUtil.closeConnection(connection);
        }
        return productCategoryList;
    }
}
