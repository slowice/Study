package hello;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import hello.io.ExcelUtil;
import hello.io.RefPartExcel;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.IOUtils;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        System.out.println(name);
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name)+"345");
    }

    @RequestMapping(value = "/fileUpload",method = RequestMethod.GET
          )
    public Map<String, Object> fileUpload() throws IOException {
//        File file = new File("/Users/xubin/1.xlsx");
//        FileInputStream input = new FileInputStream(file);
//        MultipartFile multipartFile = new MockMultipartFile("file", file.getName(), "text/plain", IOUtils.toByteArray(input));
//
//
//        Map<String, Object> map = new HashMap<String, Object>();
//        // 判断文件是否为空
//        if (file != null) {
//            try {
//                List<RefPartExcel> excelBeans = ExcelUtil.readExcel(multipartFile,RefPartExcel.class);
//                System.out.println(excelBeans.size());
//                for(RefPartExcel ep : excelBeans){
//                        System.out.println(ep.toString());
//                }
//                //........逻辑
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
      //  return map;
        return null;
    }

}