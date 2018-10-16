package xb.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xb.mall.bean.ProductInfo;
import xb.mall.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/getProductInfos")
    public List<ProductInfo> getProductInfos(){
        List<ProductInfo> productInfoList = productService.getProductList();
        return productInfoList;
    }
}
