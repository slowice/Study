package hello.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RestRequestResponseCookieSession {
    @Autowired
    HttpServletResponse response;
    @Autowired
    HttpServletRequest request;
    @RequestMapping("/xiaobintest")
    public String test() throws UnsupportedEncodingException {
        //HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        System.out.println(request.getHeaderNames());
        Cookie[] cookies = request.getCookies();
        response.setHeader("a","b");
        response.setHeader(
                "Cache-Control","no-transform,max-age=120"
        );
        String userName = getCookie(cookies,"userName");
        String userAge = getCookie(cookies,"userAge");
        if (userName == null) {
            response.addCookie(new Cookie("userName","xjdk"));
        }else{
            System.out.println(userName);
        }
        if(userAge == null){
            response.addCookie(new Cookie("userAge","18"));
        }
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","abg321");
        String x = "123";
        return x;
    }
    String getCookie(Cookie[] cookies,String key){
        if (cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(key)){
                    return cookie.getValue();
                }
            }

        }
        return null;
    }
}
