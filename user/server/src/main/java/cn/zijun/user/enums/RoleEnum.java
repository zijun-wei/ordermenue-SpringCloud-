package cn.zijun.user.enums;

import lombok.Getter;

/**
 * @Title RoleEnum
 * @Description
 * @Author Zijun Wei
 * @Date 2020/3/6
 */
@Getter
public enum RoleEnum {

    BUYER(1,"买家"),
    SELLER(2,"卖家"),
    ;

    private Integer code;
    private String roleName;

    RoleEnum(Integer code, String roleName) {
        this.code = code;
        this.roleName = roleName;
    }
}
