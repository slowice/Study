package hello.io;

import org.apache.commons.io.serialization.ValidatingObjectInputStream;

import java.io.*;

/**
 * 序列化和反序列化
 */
public class seAndUnse {

    public static void main(String[] args) throws Exception {
        input();
    }

    private static void outPut() throws IOException{
        User user = new User();
        user.setName("abg");
        FileOutputStream outputStream = new FileOutputStream(new File("/Users/xubin/Applications/user"));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(user);
        objectOutputStream.close();
        outputStream.close();
    }

    private static void input() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("/Users/xubin/Applications/user");

        ValidatingObjectInputStream inputStream = new ValidatingObjectInputStream(fileInputStream);
        //inputStream.reject(User.class);
        inputStream.accept(Serializable.class);


        //ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Object o= (Serializable) inputStream.readObject();
        User user = new User();

        user = (User)o;
        System.out.println(user.getName());
    }

}
