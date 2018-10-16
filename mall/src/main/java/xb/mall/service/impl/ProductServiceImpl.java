package xb.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xb.mall.bean.ProductInfo;
import xb.mall.dao.ProductInfoRepository;
import xb.mall.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> getProductList() {
        List<ProductInfo> productInfoList = productInfoRepository.findAll();
        return productInfoList;
    }
}
