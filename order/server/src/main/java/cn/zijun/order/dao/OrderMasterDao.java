package cn.zijun.order.dao;

import cn.zijun.order.pojo.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Title orderMaster
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/3
 */
public interface OrderMasterDao extends JpaRepository<OrderMaster,String> {
}
