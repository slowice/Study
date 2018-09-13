package xb.annotation_demo.anno;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void trackUseCases(List<Integer> useCases, Class<?> cl) {
        for (Method m : cl.getDeclaredMethods()) {
            //获得注解的对象
            UserCases.UserCase uc = m.getAnnotation(UserCases.UserCase.class);
            if (uc != null) {
                System.out.println("Found Use Case:" + uc.id() + " "
                        + uc.description());
                //useCases.remove(new Integer(uc.id()));
            }
        }
        for (int i : useCases) {
            System.out.println("Warning: Missing use case-" + i);
        }
    }

    public static void main(String[] args) {
        trackUseCases(Arrays.asList(45,46,47,48),PasswordUtils.class);
    }
}
