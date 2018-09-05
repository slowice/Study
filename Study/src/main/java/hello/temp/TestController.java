package hello.temp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hello.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;



public class TestController extends MultiActionController{



    @RequestMapping(value="/test")
    public String temp(@RequestParam String param1,Model model) throws UnsupportedEncodingException {
        System.out.println("init");
        String testParam = URLDecoder.decode(param1,"UTF-8");
        System.out.println(testParam);
        return "test";
    }



    @RequestMapping("/exporttest")
    public void exportTest(HttpServletRequest request, HttpServletResponse response) {
        List<String> list = new ArrayList<String>();
        list.add("123");
        //导出txt文件
        response.setContentType("text/plain");
        String fileName="videolist";
        try {
            fileName = URLEncoder.encode("videolist", "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        response.setHeader("Content-Disposition","attachment; filename=" + fileName + ".txt");
        BufferedOutputStream buff = null;
        StringBuffer write = new StringBuffer();
        String enter = "\r\n";
        ServletOutputStream outSTr = null;
        try {
            outSTr = response.getOutputStream();  // 建立
            buff = new BufferedOutputStream(outSTr);
            //把内容写入文件
            if(list.size()>0){
                for (int i = 0; i < list.size(); i++) {
                    write.append(list.get(i)+",");
                    write.append(enter);
                }
            }
            buff.write(write.toString().getBytes("UTF-8"));
            buff.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                buff.close();
                outSTr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @RequestMapping(value = "/baseconnect")
    @ResponseBody
    public String baseconnect(@RequestParam String user) {
        System.out.println(user);
        return null;
    }




    @RequestMapping(value = "/jsonpost", method = RequestMethod.POST)
    @ResponseBody
    //@RequestBody注解可以省略
    public String jsonPost(HttpServletRequest request, @RequestBody User user) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String userStr = objectMapper.writeValueAsString(user);
        return userStr;
    }
    @RequestMapping(value = "/jsonget")
    @ResponseBody
    public String jsonGet(){
        String jsonStr = "{&quot;name&quot;:&quot;abg&quot;}";
        return jsonStr;
    }

    @RequestMapping(value = "/entityform")
    public String entityFormTest(HttpServletRequest request) {
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartHttpServletRequest.getFile("img");
        Long fileSize;
        InputStream inputStream = null;
        BufferedOutputStream bos = null;
        if (multipartFile != null) {
            fileSize = multipartFile.getSize();
            System.out.println("getContentType     " + multipartFile.getContentType());
            System.out.println("getName     " + multipartFile.getName());
            System.out.println("getOriginalFilename     " + multipartFile.getOriginalFilename());
            try {
                inputStream = new BufferedInputStream(multipartFile.getInputStream());
                if (inputStream != null) {
                    File file = new File("D://imgStore");
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    bos = new BufferedOutputStream(new FileOutputStream(file + "123" + ".jpg"));
                    int num = 0;
                    byte[] bytes = new byte[1024];
                    while ((num = inputStream.read(bytes)) > 0) {
                        bos.write(bytes, 0, num);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    bos.close();
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return "test";
    }

    @RequestMapping(value = "/ajaxform")
    public String ajaxFormTest(User user, HttpServletRequest request) {
        System.out.println(user);
        MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) request;
        MultipartFile mf = multipart.getFile("img2");
        if (mf != null) {
            System.out.println(mf.getSize());
        }

        return "test";
    }


    public String webSocketTest() {
        return null;
    }

    @RequestMapping("/simpleRedisTestSave")
    @ResponseBody
    public void simpleRedisTestSave(@RequestParam String redisData) {
        //Jedis jedis = jedisPool.getResource();
       /* Jedis jedis = new Jedis("127.0.0.1", 6379);
        String key = Constants.Redis.getPropertyName() + redisData;
        jedis.set(key, redisData);
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: " + jedis.ping());*/
    }
}
