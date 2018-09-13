package hello.pattern.SingletonDemo;

import hello.entity.User;

public class SingletonFactoryDemo {
    private static volatile User user;

    private SingletonFactoryDemo(){
        if(user!=null){
            throw new IllegalStateException();
        }
    }

    public static User getInstance(){
        if(user==null){
            synchronized(SingletonFactoryDemo.class){
                if(user==null){
                    user = new User();
                    user.setName("SingletonFactoryDemo");
                }
            }
        }
        return user;
    }
}
