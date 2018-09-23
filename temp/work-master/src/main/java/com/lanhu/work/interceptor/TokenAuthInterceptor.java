package com.lanhu.work.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.lanhu.work.annotation.IgnoreSecurity;
import com.lanhu.work.controller.BaseController;
import com.lanhu.work.jwt.Jwt;
import com.lanhu.work.jwt.JwtResult;
import com.lanhu.work.jwt.TokenState;
import com.lanhu.work.utils.R;

@Component
public class TokenAuthInterceptor extends BaseController implements HandlerInterceptor {

	/**
	 * 日志对象
	 */
	private Logger logger = LoggerFactory.getLogger(TokenAuthInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("请求到达，开始进行处理。");
		String host = request.getHeader("X-Forwarded-For");
		if (null == host || "".equals(host.trim())) {
			host = request.getRemoteAddr();
		}
		logger.info("请求 host - [" + host + "], requestURI - [" + request.getRequestURI() + "], contentType - ["
				+ request.getContentType() + "]");

		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			if (method.isAnnotationPresent(IgnoreSecurity.class)) {
				return true;
			}
			String token = request.getHeader("token");
			// 核对token
			JwtResult jwt = Jwt.checkToken(token);
			// 如果token过期或无效
			if (!TokenState.VALID.getState().equals(jwt.getState())) {
				renderString(response, R.error(jwt.getState(), TokenState.getTokenState(jwt.getState()).getMsg()));
				return false;
			}

		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
