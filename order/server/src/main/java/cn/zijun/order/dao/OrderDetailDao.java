package cn.zijun.order.dao;

import cn.zijun.order.pojo.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Title OrderDetailDao
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/3
 */
public interface OrderDetailDao extends JpaRepository<OrderDetail,String> {
    List<OrderDetail>findByOrderId(String orderId);
}
