package cn.easybuy.service.product;

import cn.easybuy.pojo.ProductCategory;

import java.util.List;

public interface ProductCatrgoryService {
    public List<ProductCategory> queryAllProductCategory(String parentId);
}
