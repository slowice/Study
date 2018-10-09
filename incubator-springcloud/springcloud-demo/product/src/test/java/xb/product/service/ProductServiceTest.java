package xb.product.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xb.product.DTO.CartDTO;
import xb.product.ProductApplicationTests;
import xb.product.dataobject.ProductInfo;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@Component
public class ProductServiceTest extends ProductApplicationTests {
    @Autowired
    ProductService productService;

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> list = productService.findUpAll();
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void decreaseProductStock() {
        CartDTO cartDTO = new CartDTO("8461c072c47911e88118ef302013fbb6", 2);
        productService.decreaseStock(Arrays.asList(cartDTO));
    }
}