package hello.temp;

import hello.util.LogUtil;
import hello.util.SpringUtil;
import hello.util.StringUtil;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet{

    @Override
    public void init(){
        System.out.println(LogUtil.formatLog("servlet TestServlet init"));
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        ServletContext servletContext = this.getServletContext();
        WebApplicationContext webApplicationContext=WebApplicationContextUtils.getWebApplicationContext(servletContext);
        System.out.println("doGet");
        System.out.println(this.getInitParameter("i"));
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        System.out.println("doPost");
    }

    @Override
    public void destroy(){
        System.out.println("destroy");
    }
}
