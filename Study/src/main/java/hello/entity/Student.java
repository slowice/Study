package hello.entity;

import java.io.Serializable;

public class Student implements Serializable{

    private  String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
