package xb.mall.service;

import xb.mall.bean.ProductInfo;

public interface ProductCollectionService {
    void addRelation(String productId,String collectionId);
    void deleteRelation(String productId,String collectionId);
}
