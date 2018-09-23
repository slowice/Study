package com.lanhu.work.utils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 通用URL资源下载器
 */
public class URLFileDownloader {
	
	private static final Logger logger = LoggerFactory.getLogger(URLFileDownloader.class);
	
	private InputStream inputStream = null;
	
	
	private HttpURLConnection httpConn=null;
	
	
	private HttpsURLConnection httpsConn=null;
	
	
	/**
	 * 通过资源的URL下载文件到网络流
	 * @param url 资源URL
	 * @param dest 资源本地存储目的地
	 * @return 下载结果 true 成功 / false 失败
	 */
	public  InputStream httpDownload(String resURL) {

		URL url = null;
		InputStream is =null;
		try {
			url = new URL(resURL);
			httpConn = (HttpURLConnection)url.openConnection();
			httpConn.setReadTimeout(3000);
			httpConn.setConnectTimeout(3000);
			//httpConn.setRequestMethod("POST");
			//httpConn.setRequestProperty("Content-Type",   "multipart/form-data; charset=UTF-8; ");
			//防止屏蔽程序抓取而返回403错误  
			httpConn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");  
			if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				is = httpConn.getInputStream();
			}

		} catch (Exception e) {
			logger.error("httpDownload error", e);
			return null;
		} 
		return is;
	}
	

	/**
	 * 通过资源的URL下载文件到指定目录
	 * @param url 资源URL
	 * @param dest 资源本地存储目的地
	 * @return 下载结果 true 成功 / false 失败
	 */
	public  InputStream httpsDownload(String resURL) {

		URL url = null;
		InputStream is =null;
		

		try {
			url = new URL(resURL);
			httpsConn = (HttpsURLConnection)url.openConnection();
			httpsConn.setReadTimeout(3000);
			httpsConn.setConnectTimeout(3000);
			//httpsConn.setRequestMethod("POST");
			//httpsConn.setRequestProperty("Content-Type",   "multipart/form-data; charset=UTF-8; ");
			//防止屏蔽程序抓取而返回403错误  
			httpsConn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");  
            TrustManager[] tm = { new MyX509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            httpsConn.setSSLSocketFactory(ssf);

			if (httpsConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				is = httpsConn.getInputStream();
			}

		} catch (Exception e) {
			logger.error("httpsDownload error", e);
			return null;
		} 
		return is;
	}
	
	/**
	 * 通过资源的URL下载文件到指定目录
	 * @param url 资源URL
	 * @param localPath 资源本地存储目录
	 * @param fileName 文件名
	 * @return 下载结果 true 成功 / false 失败
	 */
	public  void download(String resURL) {
	    InputStream inputStream = null;
		if(resURL != null){
			if(resURL.startsWith("https")){
				inputStream = httpsDownload(resURL);
			}else{
				inputStream = httpDownload(resURL);
			}
			setInputStream(inputStream);
		}
		
	}


	private  class MyX509TrustManager implements X509TrustManager {

		// 检查客户端证书
		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}

		// 检查服务器端证书
	    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}

		// 返回受信任的X509证书数组
	    public X509Certificate[] getAcceptedIssuers() {
			return null;
		}
	}


	public InputStream getInputStream() {
		return inputStream;
	}


	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}


	
	public void destory(){
		
		try{
			if(inputStream !=null){
				inputStream.close();
				inputStream = null;
			}
			
			if(httpConn != null){
				httpConn.disconnect();
			}
			
			
			if(httpsConn != null){
				httpsConn.disconnect();
			}
		}catch(Exception e){
			logger.error("URLFileDownloader destory error ", e);
		}
	}

}
