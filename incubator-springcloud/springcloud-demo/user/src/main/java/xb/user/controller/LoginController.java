package xb.user.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xb.user.VO.ResultVO;
import xb.user.constants.UserConstants;
import xb.user.dataObject.UserInfo;
import xb.user.enums.ResultEnum;
import xb.user.enums.RoleEnum;
import xb.user.service.UserService;
import xb.user.utils.CookieUtil;
import xb.user.utils.ResultVOUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/login")
public class LoginController {

        @Autowired
        private UserService userService;

        @Autowired
        private StringRedisTemplate stringRedisTemplate;
        @GetMapping("/buyer")
        public ResultVO buyer(@RequestParam String openid, HttpServletResponse response){
            //判断openid
            UserInfo userInfo = userService.findByOpenid(openid);
            if(null == userInfo){
                return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
            }
            //判断角色
            if(!RoleEnum.BUYER.getCode().equals(userInfo.getRole())){
                return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
            }
            //添加cookie
            CookieUtil.set(response, UserConstants.OPENID,openid,UserConstants.MAX_AGE);
            return ResultVOUtil.success(null);
        }

        @GetMapping("/seller")
        public ResultVO<UserInfo> seller(@RequestParam String openid, HttpServletRequest request,HttpServletResponse response){
            //判断是否已登录
            Cookie cookie = CookieUtil.get(request,UserConstants.TOKEN);
            if(null != cookie && StringUtils.isNotBlank(stringRedisTemplate.opsForValue().get(String.format(UserConstants.TOKEN_TEMPLATE,cookie.getName())))){
                return ResultVOUtil.success(null);
            }
            //判断openid
            UserInfo userInfo = userService.findByOpenid(openid);
            if(null == userInfo){
                return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
            }
            //判断角色
            if(!RoleEnum.SELLER.getCode().equals(userInfo.getRole())){
                return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
            }
            //添加redis UUID_TOKEN = openid
            String token = UUID.randomUUID().toString();
            stringRedisTemplate.opsForValue().set(
                    String.format(UserConstants.TOKEN_TEMPLATE,token),openid,UserConstants.MAX_AGE, TimeUnit.SECONDS);
            //添加cookie
            CookieUtil.set(response, UserConstants.TOKEN,token,UserConstants.MAX_AGE);
            return ResultVOUtil.success(null);
        }
}
