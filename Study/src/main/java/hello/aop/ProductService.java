package hello.aop;

import hello.aop.target_object.annotation_test.AdminOnly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private AuthService authService;

    @AdminOnly
    public void insert(Product product){
        System.out.println("insert Product");
    }

    @AdminOnly
    public void delete(Long id){
        System.out.println("delete Product");
    }
}
