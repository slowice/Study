package hello.io;

import lombok.Data;

import java.io.IOException;
import java.io.Serializable;

@Data
public class User implements Serializable {
    private String name;

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException{
        //执行默认的readObject()方法
        in.defaultReadObject();
        //执行命令
        System.out.println("*********************");
    }
}
