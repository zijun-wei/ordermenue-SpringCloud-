package cn.zijun.order.dto;

import cn.zijun.order.enums.OrderStatusEnum;
import cn.zijun.order.enums.PayStatusEnum;
import cn.zijun.order.pojo.OrderDetail;
import cn.zijun.order.utils.EnumUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Title OrderDTO
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/3
 */
@Data
public class OrderDTO {
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenId;

    private BigDecimal orderAmount;

    /**订单状态*/
    private Integer orderStatus;

    private Integer payStatus;


    private List<OrderDetail> orderDetailList;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
    }
}
