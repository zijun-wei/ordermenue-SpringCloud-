package cn.zijun.user.controller;

import cn.zijun.user.constant.CookieConstant;
import cn.zijun.user.constant.RedisConstant;
import cn.zijun.user.enums.ResultEnum;
import cn.zijun.user.enums.RoleEnum;
import cn.zijun.user.pojo.UserInfo;
import cn.zijun.user.service.UserService;
import cn.zijun.user.utils.CookieUtil;
import cn.zijun.user.utils.ResultUtil;
import cn.zijun.user.vo.ResultVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Title LoginController
 * @Description
 * @Author Zijun Wei
 * @Date 2020/3/6
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private UserService userService;

    @GetMapping("/buyer")
    public ResultVO buyer(@RequestParam("openid")String openid,
                          HttpServletResponse response){
        UserInfo userInfo=userService.findByOpenid(openid);
        if (userInfo==null){
            return ResultUtil.error(ResultEnum.LOGIN_FAIL);
        }

        if (!RoleEnum.BUYER.getCode().equals(userInfo.getRole())){
            return ResultUtil.error(ResultEnum.LOGIN_FAIL);
        }
        CookieUtil.set(response, CookieConstant.OPENID,openid,CookieConstant.expire);
        return ResultUtil.success();
    }

    @GetMapping("/seller")
    public ResultVO seller(@RequestParam("openid")String openid,
                          HttpServletRequest request,
                          HttpServletResponse response){

        Cookie cookies=CookieUtil.get(request,CookieConstant.TOKEN);
        if (cookies!=null&&
                StringUtils.isEmpty(redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX,cookies.getValue())))){
            return ResultUtil.success();
        }
        UserInfo userInfo=userService.findByOpenid(openid);
        if (userInfo==null){
            return ResultUtil.error(ResultEnum.LOGIN_FAIL);
        }

        if (!RoleEnum.SELLER.getCode().equals(userInfo.getRole())){
            return ResultUtil.error(ResultEnum.LOGIN_FAIL);
        }
        /**
         * 设置token至redis
         */
        String token= UUID.randomUUID().toString();

        Integer expire= RedisConstant.EXPIRE;

        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX,token),openid,expire, TimeUnit.SECONDS);

        Cookie cookie=new Cookie("token",token);

        CookieUtil.set(response, CookieConstant.TOKEN,token,expire);

        return ResultUtil.success();
    }
}
