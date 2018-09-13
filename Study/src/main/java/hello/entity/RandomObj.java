package hello.entity;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class RandomObj {
    public  <T> Class<T> getFieldArr(Class<T> tClass) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = tClass.getDeclaredMethods();
        Field[] fields = tClass.getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            char[] charArr = fieldName.toCharArray();
            charArr[0] = Character.toUpperCase(charArr[0]);
            fieldName = new String(charArr);
            for (Method method : methods) {
                String methodName = method.getName();
                if(!(methodName.indexOf(fieldName) < 0)){
                    /*if (methodName.startsWith("get")) {
                        //method.invoke(tClass)
                        System.out.println(method.getName());
                        System.out.println(field.getName());
                    }*/
                    if (methodName.startsWith("set")) {

                        method.invoke(tClass,new Integer(123));
                        //System.out.println(method.getName());
                        //System.out.println(field.getName());
                    }
                }
            }
        }
        return tClass;
    }
}
