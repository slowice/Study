package hello.concurrent;


import hello.dao.UserDao;
import hello.entity.User;
import hello.util.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class A implements Runnable{
    @Override
    public void run() {
        try {

            UserDao userDao = SpringUtil.getBean("userDao",UserDao.class);
            List<User> list = userDao.selectForUpdate();
            System.out.println("thread A querySize "+list.size());
         /*   for(User user:list){
                System.out.println(user.getName());
            }*/
            List<User> list2 = new ArrayList<User>();
            User user = new User();
            user.setId(new Random().nextInt(1000));
            user.setName(String.valueOf(new Random().nextInt(1000)));
            list2.add(user);
            userDao.insertBatch(list2);
            Thread.sleep(10000);
            System.out.println(" a end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
