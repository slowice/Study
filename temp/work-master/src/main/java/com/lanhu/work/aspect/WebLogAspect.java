package com.lanhu.work.aspect;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;

@Aspect
@Component
public class WebLogAspect {
	
	 private Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

	    /**
	     * 定义一个切入点.
	     * 解释下：
	     * ~ 第一个 * 代表任意修饰符及任意返回值.
	     * ~ 第二个 * 任意包名
	     * ~ 第三个 * 代表任意方法.
	     * ~ 第四个 * 定义在web包或者子包
	     * ~ 第五个 * 任意方法
	     * ~ .. 匹配任意数量的参数.
	     */

	    @Pointcut("execution(public * com.lanhu.work.controller.*.*(..))")
	    public void webLog() {
	    }

	    @Before("webLog()")
	    public void doBefore(JoinPoint joinPoint) {
	        // 接收到请求，记录请求内容
	        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	        HttpServletRequest request = attributes.getRequest();

	        logger.info("URL:{},METHOD:{},IP:{}",request.getRequestURL().toString(),request.getMethod(),request.getRemoteAddr());
	        //获取所有参数方法一：
	        Enumeration<String> enu = request.getParameterNames();
	        while (enu.hasMoreElements()) {
	            String paraName = (String) enu.nextElement();
	            logger.info("{}:{}",paraName, request.getParameter(paraName));
	        }
	    }


	    @AfterReturning(returning = "rvt",pointcut = "webLog()")
	    public void doAfterReturning(JoinPoint joinPoint,Object rvt) {
	    	logger.info("result:{}",JSONObject.toJSONString(rvt));
	    }

}
