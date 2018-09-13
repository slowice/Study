package hello.proxy.static_proxy;

import hello.proxy.Service;
import hello.proxy.ServiceImpl;

public class ProxyServiceImpl implements Service {
    //代理类需要持有真实的实现类
    private ServiceImpl service;

    //采用构造器形式的强引用
    public ProxyServiceImpl(ServiceImpl service) {
        this.service = service;
    }

    @Override
    public void request() {
        System.out.println("before");
        service.request();
        System.out.println("after");
    }
}
