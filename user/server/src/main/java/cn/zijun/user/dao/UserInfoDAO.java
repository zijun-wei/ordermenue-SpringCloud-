package cn.zijun.user.dao;

import cn.zijun.user.pojo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Title UserInfoDAO
 * @Description
 * @Author Zijun Wei
 * @Date 2020/3/6
 */
public interface UserInfoDAO extends JpaRepository<UserInfo,String> {


    UserInfo findByOpenid(String openid);
}
