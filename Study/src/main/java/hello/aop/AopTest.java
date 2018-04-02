package hello.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AopTest {
    @Autowired
    private ProductService productService;

    @Test(expected = Exception.class)
    public void annoInsertTest(){
        CurrentUserHolder.set("Tom");
        productService.delete(1L);
    }
}
