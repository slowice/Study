package xb.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {
    //设置降级方法和服务超时
    //@HystrixCommand(fallbackMethod = "fallback",commandProperties =
    //        {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")})

    @HystrixCommand(fallbackMethod = "fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value="true"),
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="10000"),
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="60"),
    })
    @GetMapping("/getProductInfoList")
    //当此方法中出现异常时，则会触发服务降级，执行下面那个方法
    public String getProductInfoList(){
        RestTemplate restTemplate = new RestTemplate();
        String x = restTemplate.postForObject("http://127.0.0.1:8081/product/listForOrder", Arrays.asList("8461c072c47911e88118ef302013fbb6"),String.class);
        return x;
    }

    private String fallback(){
        return "太拥挤了，请稍后再试";
    }

    private String defaultFallback(){
        return "太拥挤了，请稍后再试";
    }
}
