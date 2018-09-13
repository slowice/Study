package hello.proxy.dynamic_proxy;

import hello.proxy.ServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKProxyServiceImpl implements InvocationHandler{
    private ServiceImpl service;

    public JDKProxyServiceImpl(ServiceImpl service) {
        this.service = service;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = method.invoke(service,args);
        System.out.println("after");
        return result;
    }
}
