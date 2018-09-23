package com.lanhu.work.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lanhu.work.annotation.IgnoreSecurity;
import com.lanhu.work.enums.BusErrorCode;
import com.lanhu.work.exception.ValidException;
import com.lanhu.work.pojo.UploadFileConfig;
import com.lanhu.work.service.OSSHelperService;
import com.lanhu.work.service.UploadFileConfigService;
import com.lanhu.work.utils.R;
import com.lanhu.work.vo.FileUploadVo;

@RestController
public class UploadController extends BaseController {
	
	@Autowired
	private UploadFileConfigService uploadFileConfigService;
	
	@Autowired
	private OSSHelperService osshelperService;
	
	
	 /**
     * 上传图片文件
     */
	@IgnoreSecurity
    @PostMapping(value = "/v1/upload")
    private Object upload(@Valid FileUploadVo vo,BindingResult bindingResult,HttpServletRequest request) {
    	
    	
    	List<String> urls = new ArrayList<>();
    	
    	//驗證檢驗
		if(bindingResult.hasErrors()) {
			throw new ValidException(bindingResult);
		}
		UploadFileConfig config = uploadFileConfigService.findByFileType(vo.getFileType());
		//如果filetype没有配置
		if(config == null) {
			return R.error(BusErrorCode.UPLOADFILE_CONFIG_ISNULL_ERROR);
		}
		try{
			//将request转换成多分解请求
            MultipartHttpServletRequest mhs = (MultipartHttpServletRequest)request;
            //根据input中存在的name来获取是否存在上传文件
            //这里可以用getFiles("file")的方式来处理多个文件。返回的是一个list.然后一个一个处理就可以了
            List<MultipartFile> commonsFiles = mhs.getFiles("file");
            if(commonsFiles != null && commonsFiles.size()>0) {
            	for(MultipartFile commonsFile:commonsFiles) {
    	            //获取文件原始名称
    		        String fileName = commonsFile.getOriginalFilename();
    		        //获取文件后缀
    		        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
    		        //如果上传文件后缀不在规定列表
    		        if(!config.getFileSuffix().contains(suffix.toLowerCase())){
    		        	return R.error(BusErrorCode.UPLOAD_FILE_SUF_ERROR);
    		        }
    		        //如果上传文件大小超过规定值
    		        if(commonsFile.getSize()>config.getFileMax()){
    		        	return R.error(BusErrorCode.UPLOAD_OVER_LIMIT);
    		        }
    		       // String md5 = osshelperService.md5File(commonsFile.getInputStream());
    		        urls.add(osshelperService.uploadFile2OSS(vo.getFileType(), suffix,commonsFile.getInputStream()));
        		        
            	}
            }
	       
	      
	    }catch(Exception e){
	    	logger.error("=user feedback image upload failed=", e);
	    	return R.error(BusErrorCode.FILE_UPLOAD_ERROR);
	    }
    	return R.ok(urls);
    	
    }

}
