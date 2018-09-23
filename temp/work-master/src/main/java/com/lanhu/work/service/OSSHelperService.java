package com.lanhu.work.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.PutObjectResult;
import com.lanhu.work.config.AliossConfig;
import com.lanhu.work.utils.FileNameGenerator;
import com.lanhu.work.utils.URLFileDownloader;

@Component
public class OSSHelperService {
	
	private static final Logger logger = LoggerFactory
			.getLogger(OSSHelperService.class);

	@Autowired
	private AliossConfig aliossConfig;

	/**
	 * 
	 * @param folderName
	 *            上传文件目录
	 * @param suffix
	 *            上传文件后缀
	 * @param inputStream
	 *            上传文件流
	 * @return
	 */
	public String uploadFile2OSS(String folderName, String suffix,
			InputStream inputStream) {
		OSSClient ossClient = null;
		PutObjectResult ret = null;
		logger.info("uploadFile2OSS,folderName:{},suffix:{}",folderName,suffix);
		try {
			String fileName = String.format("%s.%s",
					FileNameGenerator.generateFileName(), suffix);
			String pathName = folderName + "/" + fileName;
			ossClient = new OSSClient(aliossConfig.getEndPoint(), aliossConfig.getAccessKeyId(),
					aliossConfig.getAccessKeySecret());
			ret = ossClient.putObject(aliossConfig.getBucketName(), pathName, inputStream);
			if(ret.getETag() != null){
				return String.format("%s/%s/%s",aliossConfig.getBaseuri(), folderName,
						fileName);
			}else{
				return null;
			}
			

		} catch (Exception e) {
			logger.error("====uploadFile2OSS error", e);
			return null;
		} finally {
			try {
				if (ossClient != null) {
					ossClient.shutdown();
				}
				
			} catch (Exception e) {
				logger.error("uploadFile2OSS close inputStream error", e);
			}
		}
	}

	public String md5File(InputStream inputStream) {
		try {
			// FileInputStream fileInputStream = (FileInputStream)inputStream;
			// String md5 =
			// DigestUtils.md5Hex(IOUtils.toByteArray(inputStream));
			String md5 = BinaryUtil.encodeMD5(IOUtils.toByteArray(inputStream));
			logger.info("MD5后文件值为：{} ", md5);
			return md5;
		} catch (IOException ex) {
			logger.error("获取文件MD5错误", ex);
		}
		return null;
	}

	/**
	 * 根据网络流上传到oss
	 * 
	 * @param url
	 * @param folderName
	 * @return
	 */
	public String uploadFile2OSSByUrl(String url, String folderName) {

		URLFileDownloader downloader = new URLFileDownloader();

		//获取输入流
		downloader.download(url);

		//String md5 = md5File(downloader.getInputStream());
		// 下载网络流
		// InputStream is = downloader.getInputStream();
		// 待加密输入流
		String ret = null;
		String suffix = null;
		try {
			if ( downloader.getInputStream() != null) {
				suffix = url.substring(url.lastIndexOf(".") + 1);
				ret = uploadFile2OSS(folderName, suffix,
						downloader.getInputStream());
			}
		} catch (Exception e) {
			logger.error("====uploadFile2OSSByUrl error", e);
			return null;
		}finally{
			//资源释放
			if(downloader != null){
			     downloader.destory();
			}
		}
		return ret;
	}

	
/*	public  String generateFileUrl(String key){
		OSSClient ossClient = new OSSClient(aliossConfig.getEndPoint(), aliossConfig.getAccessKeyId(),
				aliossConfig.getAccessKeySecret());
		StringBuilder sb = new StringBuilder();
		String urlStr = null;
		// 设置URL过期时间
	    Date expiration = new Date(new Date().getTime() +  ossHttpExpire);
		// 生成URL
		 URL url =  ossClient.generatePresignedUrl(ossSecureBucketName, key, expiration);
		 if (url != null) {
			urlStr = url.toString();
			int index = urlStr.indexOf(key);
			urlStr=urlStr.substring(index);
			sb.append(ossVoiceDomain).append(urlStr);
			return sb.toString();
	     }
	     return null;
	}*/

}
