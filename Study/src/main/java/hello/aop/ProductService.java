package hello.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private AuthService authService;
    public void insert(Product product){
        //authService.checkAccess();
        System.out.println("insert Product");
    }
    @AdminOnly
    public void delete(Long id){
        //authService.checkAccess();
        System.out.println("delete Product");
    }
}
