package xb.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import xb.apigateway.constants.UserConstants;
import xb.apigateway.util.CookieUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

@Component
public class AuthFilter extends ZuulFilter {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        /*
            /order/create   只能买家端访问 && cookie里有openid
            /order/finish   只能卖家端访问 && cookie里有token，redis里有token对应的值
            /product/list   都能访问
         */
        if("/order/order/create".equals(request.getRequestURI())){
            Cookie cookie = CookieUtil.get(request,"openid");
            if(null == cookie || StringUtils.isBlank(cookie.getValue())){
                requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            }
        }

        if("/order/order/finish".equals(request.getRequestURI())){
            Cookie cookie = CookieUtil.get(request,"token");
            if(null == cookie
                    || StringUtils.isBlank(cookie.getValue())
        ||  StringUtils.isBlank(stringRedisTemplate.opsForValue().get(String.format(UserConstants.TOKEN_TEMPLATE,cookie.getValue())))
            ){
                requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            }
        }

        return null;
    }
}
