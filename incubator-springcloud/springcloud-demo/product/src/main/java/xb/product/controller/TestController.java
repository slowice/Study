package xb.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/msg")
    public String test() {
        return " this is Product Msg";
    }
}
