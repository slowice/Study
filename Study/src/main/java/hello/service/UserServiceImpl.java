package hello.service;

import hello.dao.UserDao;
import hello.entity.User;
import hello.util.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private PlatformTransactionManager transactionManager;
    @Autowired
    private UserDao userDao;


    @Transactional
    @Override
    public void programmaticTransactionTest1(){
        UserDao userDao = SpringUtil.getBean("userDao",UserDao.class);
        //List<User> list = userDao.selectForUpdate();
        //List<User> list = userDao.selectAll();
        //System.out.println("thread A querySize "+list.size());
        User user = userDao.selectOneForUpdate(835);
        System.out.println(user.getName());

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" thread a end");
    }

    /**
     * 这个方法使用编程式事务和声明式事务有本质的区别。编程式事务可以控制在下面的线程中保证循环结束后才释放数据库锁，其它线程才能对数据库进行操作。
     * 若只是简单的使用声明式事务的话，每次循环均会提交一次事务。这样的话，在第一次循环后，表会被另个线程的select for update锁住，后续操作阻塞
     * 另外，使用编程式事务，会对数据库加锁，其它线程若要竞争表锁，则会被阻塞，若申请行锁，不会被阻塞。
     */
    //@Transactional
    @Override
    public void programmaticTransactionTest2(){
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
                for(int i=0;i<5;i++){
                    UserDao userDao = SpringUtil.getBean("userDao",UserDao.class);
                    User user = new User();
                    user.setId(i);
                    user.setName(String.valueOf(i));
                    userDao.insert(user);
                    System.out.println("Thread b query time:"+i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                transactionManager.commit(status);
                System.out.println("thread b end");
            }
        });
        b.start();
    }

    @Transactional
    @Override
    public void programmaticTransactionTest3() {
        for(int i=0;i<3;i++){
            User user = new User();
            user.setId(i);
            user.setName(String.valueOf(i));
            userDao.insert(user);
        }
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public User select(Integer id) {
        User user = userDao.select(id);
        return user;
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

}
