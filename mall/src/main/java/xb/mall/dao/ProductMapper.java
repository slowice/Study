package xb.mall.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xb.mall.bean.ProductInfo;
import xb.mall.bean.responseObj.ProductInfoReponse;

import java.util.List;

@Mapper
public interface ProductMapper{
    List<ProductInfoReponse> getProductInfoListByCategoryName(String categoryName);

    List<ProductInfo> getProductListByCollectionId(String collectionId);

    ProductInfoReponse getProductInfoById(String productId);

    void addProductCollectionRelation(String productId,String collectionId);
    void deleteProductCollectionRelation(@Param("productId") String productId, @Param("collectionId") String collectionId);
}
