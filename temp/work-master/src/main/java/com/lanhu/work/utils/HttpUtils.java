package com.lanhu.work.utils;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpUtils {

	private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

	@Autowired
	RestTemplate restTemplate;

	public HttpHeaders getHttpJsonHeaders() {
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(type);
		return headers;
	}

	public HttpHeaders getHttpTextHeaders() {
		MediaType type = MediaType.parseMediaType("text/plain; charset=UTF-8");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(type);
		return headers;
	}

	public HttpHeaders getHttpAuthJsonHeaders(String token) {
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(type);
		headers.add("Authorization", "Basic " + token);
		return headers;
	}

	public HttpHeaders getHttpAuthTextHeaders(String token) {
		MediaType type = MediaType.parseMediaType("text/plain; charset=UTF-8");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(type);
		headers.add("Authorization", "Basic " + token);
		return headers;
	}

	public HttpHeaders getHttpJsonHeaders(Map<String, String> headerMap) {
		HttpHeaders headers = new HttpHeaders();
		for (Map.Entry<String, String> h : headerMap.entrySet()) {
			if (h.getKey().equalsIgnoreCase("content-type")) {
				headers.setContentType(MediaType.parseMediaType("text/plain; charset=UTF-8"));
			} else {
				headers.add(h.getKey(), h.getValue());
			}
		}
		return headers;
	}

	public String httpPostText(String url, String httpEntity) {
		logger.debug("request url:{},body:{}", url, httpEntity);
		HttpEntity<String> formEntity = new HttpEntity<String>(httpEntity, getHttpTextHeaders());
		try {
			ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, formEntity, String.class);
			String response = responseEntity.getBody();
			logger.debug("response body:{}", response);
			return response;
		} catch (Exception e) {
			logger.error("httpPostText通信时异常", e);
			return null;
		}

	}

	public String httpPostForJSON(String url, String httpEntity) {
		logger.debug("request url:{},body:{}", url, httpEntity);
		HttpEntity<String> formEntity = new HttpEntity<String>(httpEntity, getHttpJsonHeaders());
		try {
			ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, formEntity, String.class);
			String body = responseEntity.getBody();
			logger.debug("response body:{}", body);
			return body;
		} catch (Exception e) {
			logger.error("httpPostForJSON通信时异常", e);
			return null;
		}
	}

	public String httpPostAuthText(String url, String httpEntity, String token) {
		logger.debug("request url:{},body:{}", url, httpEntity);
		HttpEntity<String> formEntity = new HttpEntity<String>(httpEntity, getHttpAuthTextHeaders(token));
		try {
			ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, formEntity, String.class);
			String body = responseEntity.getBody();
			logger.debug("response body:{}", body);
			return body;
		} catch (Exception e) {
			logger.error("httpPostAuthText通信时异常", e);
		}
		return null;
	}

	public String httpPostAuthJson(String url, String httpEntity, String token) {
		logger.debug("request url:{},body:{}", url, httpEntity);
		HttpEntity<String> formEntity = new HttpEntity<String>(httpEntity, getHttpAuthJsonHeaders(token));
		try {
			ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, formEntity, String.class);
			String body = responseEntity.getBody();
			logger.debug("response body:{}", body);
			return body;
		} catch (Exception e) {
			logger.error("httpPostAuthJson通信时异常", e);
		}
		return null;
	}

	public String httpPostHeaders(String url, String httpEntity, Map<String, String> headers) {
		logger.debug("request url:{},body:{}", url, httpEntity);
		HttpEntity<String> formEntity = new HttpEntity<String>(httpEntity, getHttpJsonHeaders(headers));
		try {
			ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, formEntity, String.class);
			String jsonResponse = responseEntity.getBody();
			logger.debug("response body:{}", jsonResponse);
			return jsonResponse;
		} catch (Exception e) {
			logger.error("httpPostHeaders通信时异常", e);
		}
		return null;
	}

	public String httpGet(String url, String httpEntity) {
		logger.debug("request body:{}", httpEntity);
		try {
			ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class, httpEntity);
			String body = responseEntity.getBody();
			logger.debug("response body:{}", body);
			return body;
		} catch (Exception e) {
			logger.error("httpGet通信时异常", e);
		}
		return null;
	}

	public String httpGetByParam(String url, Map<String, Object> map) {
		logger.debug("request body:{}", map);
		try {
			ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class, map);
			String jsonResponse = responseEntity.getBody();
			logger.debug("response body:{}", jsonResponse);
			return jsonResponse;
		} catch (Exception e) {
			logger.error("httpGet通信时异常", e);
		}
		return null;
	}

}
