package xb.product.service;

import xb.product.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService {
    List<ProductCategory> findCategoryTypeIn(List<Integer> categoryTypeList);
}
