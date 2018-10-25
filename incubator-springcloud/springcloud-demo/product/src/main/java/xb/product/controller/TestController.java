package xb.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xb.product.config.BoyConfig;

@RestController
public class TestController {
    @Autowired
    BoyConfig boyConfig;

    @GetMapping("/msg")
    public String test() {
        return " this is Product Msg";
    }

    @GetMapping("/test1")
    public String test1() {
        return boyConfig.getName();
    }
}
