package hello.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@RequestScope
//@SessionScope
@Component
public class Foo implements Lifecycle {


    @Override
    public void start() {
        System.out.println("开始啊啊啊啊啊啊啊啊");
    }

    @Override
    public void stop() {
        System.out.println("结束啊啊啊啊啊啊啊啊");
    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
