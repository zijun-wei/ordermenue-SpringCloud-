package cn.zijun.user.service;

import cn.zijun.user.pojo.UserInfo;

/**
 * @Title UserService
 * @Description
 * @Author Zijun Wei
 * @Date 2020/3/6
 */
public interface UserService {

    UserInfo findByOpenid(String openid);
}
