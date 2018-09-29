package xb.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import xb.order.client.ProductClient;
import xb.order.dataobject.ProductInfo;

import java.util.Arrays;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/test")
    public void test(){
        String xx = restTemplate.getForObject("http://PRODUCT/msg",String.class);
        System.out.println(xx);
    }

    @GetMapping("/getProductMsg")
    public String getProductMsg(){
        String response = productClient.productMsg();
        return response;
    }

    @GetMapping("/test2")
    public void test2(){
        List<ProductInfo> list = productClient.listForOrder(Arrays.asList("1","2"));
        System.out.println(list.size());
    }
}
