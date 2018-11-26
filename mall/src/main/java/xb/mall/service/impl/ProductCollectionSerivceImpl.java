package xb.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xb.mall.dao.ProductMapper;
import xb.mall.service.ProductCollectionService;

@Service
public class ProductCollectionSerivceImpl implements ProductCollectionService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public void addRelation(String productId, String collectionId) {
        productMapper.addProductCollectionRelation(productId,collectionId);
    }

    @Override
    public void deleteRelation(String productId, String collectionId) {
        productMapper.deleteProductCollectionRelation(productId,collectionId);
    }
}
