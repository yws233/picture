package cn.easybuy.dao.product;

import cn.easybuy.pojo.ProductCategory;

import java.util.List;

/**
 * 查询所有的商品分类信息
 * @author natural
 * @params parentId
 * @return list
 */

public interface ProductCategoryDao {
    public List<ProductCategory> queryAllProductCategory(String parentId);
}
