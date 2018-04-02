package hello.proxyTest;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class ProxyTestUtil implements InvocationHandler{
    private Object target;
    public ProxyTestUtil(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = method.invoke(target,args);
        System.out.println("after");
        return result;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
