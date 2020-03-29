package cn.zijun.apigateway.filter;

import cn.zijun.apigateway.constant.RedisConstant;
import cn.zijun.apigateway.utils.CookieUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @Title AuthFilter
 * @Description
 * @Author Zijun Wei
 * @Date 2020/3/6
 */
//@Component
//public class AuthFilter extends ZuulFilter {
//
//    @Autowired
//    private StringRedisTemplate redisTemplate;
//
//    @Override
//    public String filterType() {
//        return PRE_TYPE;
//    }
//
//    @Override
//    public int filterOrder() {
//        return PRE_DECORATION_FILTER_ORDER-1;
//    }
//
//    @Override
//    public boolean shouldFilter() {
//        return true;
//    }
//
//    @Override
//    public Object run() throws ZuulException {
//        RequestContext requestContext=new RequestContext();
//        HttpServletRequest request = requestContext.getRequest();
//
//
//        if ("/order-service/order/create".equals(request.getRequestURI())){
//            Cookie cookie = CookieUtil.get(request, "openid");
//            if (cookie==null||StringUtils.isEmpty(cookie.getValue())){
//                requestContext.setSendZuulResponse(false);
//                requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
//            }
//        }
//        if ("/order-service/order/finish".equals(request.getRequestURI())){
//            Cookie cookie = CookieUtil.get(request, "token");
//            if (cookie==null||StringUtils.isEmpty(cookie.getValue())||
//                    StringUtils.isEmpty(redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue())))){
//                requestContext.setSendZuulResponse(false);
//                requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
//            }
//        }
//
//        return null;
//    }
//}
