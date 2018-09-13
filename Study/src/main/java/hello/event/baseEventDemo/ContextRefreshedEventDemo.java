package hello.event.baseEventDemo;


import hello.util.LogUtil;
import hello.util.StringUtil;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class ContextRefreshedEventDemo implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println(LogUtil.formatLog(this.getClass().getName()));
    }
}

