package hello.proxy;

public class ServiceImpl implements Service{
    @Override
    public void request() {
        System.out.println("this is real serviceImpl");
    }
}
