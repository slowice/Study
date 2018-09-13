package hello.ioc.context;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class ApplicationContextTest {
    public ApplicationContext getXmlWebApplicationContext(HttpServletRequest request){
        ServletContext servletContext = request.getSession().getServletContext();
        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        return applicationContext;
    }

    public static ApplicationContext getApplicationContext(){
        ServletContext context = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(context);
        return applicationContext;
    }
}
