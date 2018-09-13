package hello.ioc.bean;

import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

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
