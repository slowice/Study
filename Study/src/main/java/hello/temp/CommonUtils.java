package hello.temp;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.entity.User;

import java.io.IOException;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CommonUtils {
    public static void main(String[] args) {
        jsonToPojo();
    }
    //arrStr to List
    public static void strToList(String str,List list){
        String xx = "1,,呵呵";
        String[] strArr = xx.split(",");
        list = Arrays.asList(strArr);
    }

    //jsonStr to Entity
    public static void jsonToPojo(){
        String str = "{\"name\":\"abg\",\"age\":18,\"amount\":18.5,\"date\":\"2017-07-07\",\"handsome\":\"false\",\n" +
                "                \"students\":[\"xiaoming\",\"zhongming\",\"daming\"],\"teachers\":[{\"name\":\"xiaohong\"},{\"name\":\"xiaohuang\"}]}";
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        User user=null;
        try {
            user = mapper.readValue(str,User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }
}
