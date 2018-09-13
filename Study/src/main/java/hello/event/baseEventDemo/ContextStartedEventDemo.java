package hello.event.baseEventDemo;


import hello.util.LogUtil;
import hello.util.StringUtil;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class ContextStartedEventDemo implements ApplicationListener<ContextStartedEvent> {
    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println(LogUtil.formatLog(this.getClass().getName()));
    }
}

