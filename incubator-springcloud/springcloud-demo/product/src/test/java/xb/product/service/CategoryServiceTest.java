package xb.product.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xb.product.dataobject.ProductCategory;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {
    @Autowired
    CategoryService categoryService;

    @Test
    public void findCategoryTypeIn() throws Exception {
        List<ProductCategory> list = categoryService.findCategoryTypeIn(Arrays.asList(11,22));
        assertTrue(list.size() > 0);
    }

}