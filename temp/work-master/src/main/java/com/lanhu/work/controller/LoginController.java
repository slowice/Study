package com.lanhu.work.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lanhu.work.annotation.IgnoreSecurity;
import com.lanhu.work.enums.UploadFileType;
import com.lanhu.work.exception.ValidException;
import com.lanhu.work.pojo.User;
import com.lanhu.work.service.OSSHelperService;
import com.lanhu.work.service.UserService;
import com.lanhu.work.utils.IpUtils;
import com.lanhu.work.utils.R;
import com.lanhu.work.vo.ThirdUserloginVo;

/**
 * 
 * @author liuyi
 *
 */
@RestController
public class LoginController extends BaseController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OSSHelperService ossHelperService;
	
	@IgnoreSecurity
	@PostMapping(value="/v1/thirdUser/login")
	public Object thirdUserlogin(@Valid ThirdUserloginVo vo,BindingResult bindingResult,HttpServletRequest request) {
		//驗證檢驗
		if(bindingResult.hasErrors()) {
			throw new ValidException(bindingResult);
		}
		
		//设置用户访问IP
		vo.setIp(IpUtils.getIpAddr(request));
		
		User user = userService.thirdUserLogin(vo.getOpenId(), vo.getUserType());
		//如果用户为空
		if(user == null) {
			user = new User();
			//属性赋值
			BeanUtils.copyProperties(vo, user);
			//设置头像
			if(user.getAvatar() != null) {
				//设置用户头像
				user.setAvatar(ossHelperService.uploadFile2OSSByUrl(vo.getAvatar(), UploadFileType.FAVICON.getFileType()));
			}
		}
		//用户登陆操作
		userService.thirdUserLogin(user,vo);
		return R.ok(user);
	}

}
