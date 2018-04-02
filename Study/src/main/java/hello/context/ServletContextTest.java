package hello.context;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

public class ServletContextTest {
    WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
    ServletContext servletContext = webApplicationContext.getServletContext();
}
