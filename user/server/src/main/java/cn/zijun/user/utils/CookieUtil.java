package cn.zijun.user.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title CookieUtil
 * @Description
 * @Author Zijun Wei
 * @Date 2020/3/6
 */
public class CookieUtil {
    public static void set(HttpServletResponse response, String cookieName, String cookieValue, Integer expire) {
        Cookie cookie=new Cookie(cookieName,cookieValue);
        cookie.setPath("/");
        cookie.setMaxAge(expire);
        response.addCookie(cookie);
    }

    public static Cookie get(HttpServletRequest request,String name){
        Cookie[] cookies = request.getCookies();
        Map<String,Cookie>cookieMap=getCookieMap(cookies);
        if (cookieMap.containsKey(name)){
            return cookieMap.get(name);
        }else{
            return null;
        }
    }

    public  static Map<String,Cookie> getCookieMap(Cookie[]cookies){
        Map<String,Cookie>cookieMap=new HashMap<>();
        if (cookies!=null){
            for (Cookie cookie:cookies){
                cookieMap.put(cookie.getName(),cookie);
            }
        }
        return cookieMap;
    }
}
