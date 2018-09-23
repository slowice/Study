package com.lanhu.work.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.lanhu.work.interceptor.SignAuthIntercept;
import com.lanhu.work.interceptor.TokenAuthInterceptor;

@Configuration
public class HandlerInterceptorBean  implements WebMvcConfigurer{

    @Autowired
	private TokenAuthInterceptor tokenAuthInterceptor;
    
    @Autowired
    private SignAuthIntercept signAuthIntercept;
    
    
	//添加拦截器.
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenAuthInterceptor).addPathPatterns("/api/**");
        registry.addInterceptor(signAuthIntercept).addPathPatterns("/api/**");
    }
	

}
