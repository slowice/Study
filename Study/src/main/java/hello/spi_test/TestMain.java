package hello.spi_test;

import java.util.ServiceLoader;

public class TestMain {
    public static void main(String[] args) {
        ServiceLoader<TestService> testServices = ServiceLoader.load(TestService.class);
        for(TestService testService:testServices){
            testService.excute();
        }
    }
}
