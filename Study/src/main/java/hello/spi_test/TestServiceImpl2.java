package hello.spi_test;

public class TestServiceImpl2 implements TestService {
    @Override
    public void excute() {
        System.out.println("我是实现类2");
    }
}
