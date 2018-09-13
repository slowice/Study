package hello.filter;

import hello.util.StringUtil;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@Component
//@ServletComponentScan
//@WebFilter(urlPatterns = "/*",filterName = "testFilter")
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //System.out.println(StringUtil.formatLog(this.getClass().getName()));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //System.out.println(this.getClass().getMethods()[0].getName()+":222222");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

        //System.out.println(this.getClass().getMethods()[0].getName()+":33333"
        //);
    }
}
