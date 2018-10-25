package xb.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import xb.order.client.ProductClient;
import xb.order.config.GirlConfig;
import xb.order.dataobject.ProductInfo;

import java.util.Arrays;
import java.util.List;

@RestController
@RefreshScope
public class TestController {
    @Autowired
    GirlConfig girlConfig;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/test1")
    public void test() {
        //第一种方式，记得关掉restTemplate配置类中的loadBalance注解
        RestTemplate restTemplate = new RestTemplate();
        String xx = restTemplate.getForObject("http://localhost:8081/msg", String.class);
        System.out.println(xx);
    }

    @GetMapping("/test2")
    public String test2() {
        //第二种方式，获得ServiceInstance，再来拼接host和port
        RestTemplate restTemplate = new RestTemplate();
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        String url = String.format("http://%s:%s/msg", serviceInstance.getHost(), serviceInstance.getPort());
        String response = restTemplate.getForObject(url, String.class);
        return response;
    }

    @GetMapping("/test3")
    public String test3() {
        //第三方式，和第二种方式差不多，只不过是换了注解的形式
        String response = restTemplate.getForObject("http://PRODUCT/msg", String.class);
        return response;
    }

    @GetMapping("/test4")
    public void test4() {
        String girlName = girlConfig.getName();
        System.out.println(girlName);
    }


    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        String response = productClient.productMsg();
        return response;
    }

}
