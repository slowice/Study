package hello.service;

import hello.entity.User;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface UserService {
    void programmaticTransactionTest1();
    void programmaticTransactionTest2();
    void programmaticTransactionTest3();

    void insert(User user);
    void delete(User user);
    User select(Integer id);
    void update(User user);

    void test(HttpServletResponse response) throws IOException;
}
