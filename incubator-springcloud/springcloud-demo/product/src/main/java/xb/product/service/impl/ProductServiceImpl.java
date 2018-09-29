package xb.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xb.product.dataobject.ProductInfo;
import xb.product.enums.ProductStatusEnum;
import xb.product.repository.ProductInfoRepository;
import xb.product.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findList(List<String> list) {
        return productInfoRepository.findByProductIdIn(list);
    }
}
