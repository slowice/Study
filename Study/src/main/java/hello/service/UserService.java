package hello.service;

import hello.entity.User;

public interface UserService {
    void programmaticTransactionTest1();
    void programmaticTransactionTest2();
    void programmaticTransactionTest3();

    void insert(User user);
    void delete(User user);
    User select(Integer id);
    void update(User user);
}
