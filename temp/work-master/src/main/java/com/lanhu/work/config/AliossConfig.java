package com.lanhu.work.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 阿里OSS上传服务配置
 * @author lonyee
 *
 */
@Configuration
@PropertySource(value="classpath:config/alioss.properties")
@ConfigurationProperties(prefix = "alioss")
public class AliossConfig {
	private String bucketName;
	private String endPoint;
	private String accessKeyId;
	private String accessKeySecret;
	private String baseuri;



	public String getBucketName() {
		return bucketName;
	}
	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}
	public String getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}
	public String getAccessKeyId() {
		return accessKeyId;
	}
	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}
	public String getAccessKeySecret() {
		return accessKeySecret;
	}
	public void setAccessKeySecret(String accessKeySecret) {
		this.accessKeySecret = accessKeySecret;
	}
	public String getBaseuri() {
		return baseuri;
	}
	public void setBaseuri(String baseuri) {
		this.baseuri = baseuri;
	}
	
}
