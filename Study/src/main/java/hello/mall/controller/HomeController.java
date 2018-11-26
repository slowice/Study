package hello.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mall")
public class    HomeController {

    @RequestMapping("/home")
    public String test(){
        return "home";
    }

    @RequestMapping("/introduction")
    public String goToIntroduction(){
        return "introduction";
    }



}
