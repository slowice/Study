package hello.util;

import hello.entity.Student;
import hello.entity.User;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class BeanUtilsTest {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        test1();
    }

    //copyProperties 此方法是依赖于域的set方法
    private static void test1() throws InvocationTargetException, IllegalAccessException {
        User u1 = new User();
        u1.setId(1);
        u1.setName("hehe");
        Student s = new Student();
        BeanUtils.copyProperties(s, u1);
        System.out.println(s);
    }
}
