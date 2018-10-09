package hello.io;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/io")
public class OutToBrowser {

    @RequestMapping("/test1")
    public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(request.getRequestURI());
        String content = "<p style='color:red'>${txt}</p>";
        content = content.replace("${txt}","hehe");
        response.getWriter().write(content);
    }
}
