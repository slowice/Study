package hello.event.baseEventDemo;

import hello.util.LogUtil;
import hello.util.StringUtil;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.RequestHandledEvent;

//@Controller
@RequestMapping("/RequestHandledEventDemo")
public class RequestHandledEventDemo implements ApplicationListener<RequestHandledEvent> {
    @Override
    public void onApplicationEvent(RequestHandledEvent event) {
        System.out.println(LogUtil.formatLog(this.getClass().getName()));
    }

    @RequestMapping("/test")
    public String test(){
        System.out.println("RequestHandledEventDemo.test()");
        return null;
    }
}
