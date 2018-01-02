package cn.easybuy.dao.product;

import cn.easybuy.dao.BaseDao;
import cn.easybuy.pojo.ProductCategory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductCategoryDaoImpl extends BaseDao implements ProductCategoryDao{

    /*private Connection connection;
    private PreparedStatement pstm;
    private ResultSet rs;*/

    public ProductCategoryDaoImpl(Connection connection) {
        super(connection);
    }

    public ProductCategory tableToClass(ResultSet rs) throws Exception{
        ProductCategory pc = new ProductCategory();
        pc.setId(rs.getInt("id"));
        pc.setName(rs.getString("name"));
        pc.setType(rs.getInt("type"));
        pc.setParentId(rs.getInt("parentId"));
        pc.setIconClass(rs.getString("iconClass"));
        return pc;
    }

    //依据id查询数据库
    @Override
    public List<ProductCategory> queryAllProductCategory(String parentId) {
        List<ProductCategory> productCategoryList = new ArrayList<ProductCategory>();
        StringBuffer sql = new StringBuffer("SELECT id,name,parentId,type,iconClass  FROM easybuy_product_category where 1=1 ");
        List<Object> params = new ArrayList<Object>();
        ResultSet rs = null;
        if (null != parentId && !"".equals(parentId)){
             sql.append("and parentId = ?");
             params.add(parentId);
        }
        try {
            /*pstm = connection.prepareStatement(sql.toString());
            if (null != parentId && !"".equals(parentId)){
                pstm.setObject(1,parentId);
            }
            rs = pstm.executeQuery();*/
            rs = this.executeQuery(sql.toString(),params.toArray()); //使用list后转为数组，方便修改
            while (rs.next()){
                ProductCategory pc = null;
                try {
                    pc = tableToClass(rs);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                productCategoryList.add(pc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource();
        }
        return productCategoryList;
    }
}
