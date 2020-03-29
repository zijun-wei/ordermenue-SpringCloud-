package cn.zijun.order.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @Title orderForm
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/3
 */
@Data
public class OrderForm {
    @NotEmpty(message = "姓名必填")
    private String name;

    @NotEmpty(message = "手机号必填")
    private String phone;

    @NotEmpty(message = "地址必填")
    private String address;

    @NotEmpty(message = "openid必填")
    private String openid;

    @NotEmpty(message = "购物内容必填")
    private String items;
}
