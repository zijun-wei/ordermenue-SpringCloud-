package cn.zijun.user.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Title SellerInfo
 * @Description
 * @Author Zijun Wei
 * @Date 2020/3/6
 */
@Entity
@Data
public class UserInfo {
    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;

    private Integer role;
}
