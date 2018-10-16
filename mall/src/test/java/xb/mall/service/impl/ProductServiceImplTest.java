package xb.mall.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xb.mall.MallApplicationTests;
import xb.mall.bean.ProductInfo;
import xb.mall.dao.ProductInfoRepository;

import java.util.List;

import static org.junit.Assert.*;

@Component
public class ProductServiceImplTest extends MallApplicationTests {

    @Autowired
    ProductInfoRepository productInfoRepository;
    @Test
    public void getProductList() {
        List<ProductInfo> productInfoList = productInfoRepository.findAll();
        Assert.assertTrue(productInfoList.size()>0);
    }
}