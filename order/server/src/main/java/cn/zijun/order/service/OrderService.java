package cn.zijun.order.service;

import cn.zijun.order.dto.OrderDTO;

/**
 * @Title OrderMasterService
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/3
 */
public interface OrderService {
    public OrderDTO create(OrderDTO orderDTO);

    public OrderDTO finish(String orderId);
}
