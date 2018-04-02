package hello.proxyTest;

import java.lang.reflect.Proxy;

public class MainTest {
    public static void main(String[] args) {
        /*Object proxyObject = new ProxyTestServiceImpl();
        ProxyTestUtil proxyTestUtil = new ProxyTestUtil(proxyObject);
        ProxyTestService proxyTestService = (ProxyTestService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),ProxyTestServiceImpl.class.getInterfaces(),proxyTestUtil);
        proxyTestService.test();*/

        Object proxyObject = new ProxyTestServiceImpl();
        CGProxy cgProxy = new CGProxy(proxyObject);
        ProxyTestService proxyTestService =  (ProxyTestService) cgProxy.getProxyObject();
        proxyTestService.test();
    }
}
