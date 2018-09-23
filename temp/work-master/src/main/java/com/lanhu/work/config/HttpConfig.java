package com.lanhu.work.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value="classpath:config/http.properties")
@ConfigurationProperties(prefix = "http")
public class HttpConfig {
	
	private int readTimeout;
	
	
	private int connectTimeout;


	public int getReadTimeout() {
		return readTimeout;
	}


	public void setReadTimeout(int readTimeout) {
		this.readTimeout = readTimeout;
	}


	public int getConnectTimeout() {
		return connectTimeout;
	}


	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}
	
	
	

}
