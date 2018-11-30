package xb.mall.common.filter;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.boot.web.servlet.support.ErrorPageFilter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component

public class MyErrorPageFilter implements ErrorPageRegistrar {
        @Override
        public void registerErrorPages(ErrorPageRegistry registry) {
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "404");
            //ErrorPage error405Page = new ErrorPage(HttpStatus.METHOD_NOT_ALLOWED, "/WEB-INF/errorpage/405.html");
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/WEB-INF/errorpage/500.html");
            registry.addErrorPages(error404Page);
        }

}
