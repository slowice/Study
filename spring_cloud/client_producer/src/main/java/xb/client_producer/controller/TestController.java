package xb.client_producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/getTest")
    public String test(){
        return "this is from client_producer";
    }
}
