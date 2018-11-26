package hello.proxy.dynamic_proxy;

import hello.proxy.Service;
import hello.proxy.ServiceImpl;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

public class Test {
    public static void jdkProxyTest(){
        //传入 ClassLoader,目标接口，代理对象
        Service service = (Service) Proxy.newProxyInstance(
                Test.class.getClassLoader(),new Class[]{Service.class},new JDKProxyServiceImpl(new ServiceImpl())
        );
        service.request();
    }

    public static void cglibProxyTest(){
        //传入 目标接口实现类 以及 代理类
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ServiceImpl.class);
        enhancer.setCallback(new CGLIBProxyServiceImpl());
        Service service = (Service) enhancer.create();
        service.request();
    }

    public static void main(String[] args) {
        cglibProxyTest();
    }
}
