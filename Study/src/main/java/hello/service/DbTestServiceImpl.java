package hello.service;

import hello.dao.DbTest;
import hello.transaction.CustomizeTransactionTest;
import hello.transaction.MyTransactional;
import hello.transaction.TestModel;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class DbTestServiceImpl implements DbTestService{

    @MyTransactional
    @Override
    public void add() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(CustomizeTransactionTest.class);
        annotationConfigApplicationContext.refresh();
        DbTest dbTest = annotationConfigApplicationContext.getBean(DbTest.class);
        dbTest.add(new TestModel("test"));
        throw new NullPointerException();
    }
}
