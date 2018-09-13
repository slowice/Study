package hello.proxy.static_proxy;

import hello.proxy.Service;
import hello.proxy.ServiceImpl;

public class Test {
    public static void main(String[] args) {
        Service service = new ProxyServiceImpl(new ServiceImpl());
        service.request();
    }
}
