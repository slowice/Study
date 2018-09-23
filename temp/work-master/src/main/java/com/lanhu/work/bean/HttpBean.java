package com.lanhu.work.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.lanhu.work.config.HttpConfig;

@Configuration
public class HttpBean {
	
	@Autowired
	private HttpConfig httpConfig;
	
	@Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory){
        return new RestTemplate(factory);
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(httpConfig.getReadTimeout());//单位为ms
        factory.setConnectTimeout(httpConfig.getConnectTimeout());//单位为ms
        return factory;
    }

}
