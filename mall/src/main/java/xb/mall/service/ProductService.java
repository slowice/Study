package xb.mall.service;

import com.github.pagehelper.Page;
import xb.mall.bean.ProductInfo;
import xb.mall.bean.requestObj.ProductInfoRequest;
import xb.mall.bean.responseObj.ProductInfoReponse;

import java.util.List;

public interface ProductService {
    List<ProductInfo> getProductListAll();

    List<ProductInfoReponse> getProductListByCategoryName(String categoryName);

    List<ProductInfoReponse> getAll();

    List<ProductInfo> getProductListByCollectionId(String collectionId);

    Page<ProductInfo> getProductInfoPaged();

    ProductInfoReponse getProductAndCategoryById(String productId);

    ProductInfo getProductInfoById(String productId);

    void saveProduct(ProductInfoRequest request);

    void deleteProduct(String productId);
}
