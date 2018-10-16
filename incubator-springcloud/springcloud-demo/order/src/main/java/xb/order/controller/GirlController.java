package xb.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xb.order.config.GirlConfig;

@RestController
public class GirlController {
    @Autowired
    GirlConfig girlConfig;

    @GetMapping("/girl")
    public String getGirlConfig(){
        return girlConfig.getName() + girlConfig.getAge();
    }
}
