package xb.client;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/actuator/info")
    @ResponseBody
    public String test() {
        return "123";
    }
}
