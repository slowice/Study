package hello.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hello.dto.ResponseDTO;
import hello.entity.User;

import java.util.ArrayList;
import java.util.List;

public class JsonDemo {
    public static void main(String[] args) throws JsonProcessingException {
        List list = new ArrayList();
        list.add(new User());
        ResponseDTO responseDTO = new ResponseDTO("01","hehe");
        System.out.println(responseDTO);
    }
}
