package hello.spi_test;

public class TestServiceImpl implements TestService {
    @Override
    public void excute() {
        System.out.println("我是实现类1");
    }
}
