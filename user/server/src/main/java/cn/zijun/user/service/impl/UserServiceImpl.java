package cn.zijun.user.service.impl;

import cn.zijun.user.dao.UserInfoDAO;
import cn.zijun.user.pojo.UserInfo;
import cn.zijun.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Title UserServiceImpl
 * @Description
 * @Author Zijun Wei
 * @Date 2020/3/6
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoDAO userInfoDAO;

    @Override
    public UserInfo findByOpenid(String openid) {
        return userInfoDAO.findByOpenid(openid);
    }
}
