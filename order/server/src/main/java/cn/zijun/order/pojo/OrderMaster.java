package cn.zijun.order.pojo;

import cn.zijun.order.enums.OrderStatusEnum;
import cn.zijun.order.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Zijun_Wei
 * @Title OrderMaster
 * @Description 订单实体
 * @date 2019/12/30
 */

@Entity
@Data
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
public class OrderMaster {

    @Id
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    /** 买家微信openid */
    @Column(name = "buyer_openid")
    private String buyerOpenId;

    private BigDecimal orderAmount;

    /**订单状态*/
    private Integer orderStatus= OrderStatusEnum.NEW.getCode();

    private Integer payStatus= PayStatusEnum.WAIT.getCode();

    @CreatedDate
    private Date createTime;

    @LastModifiedDate
    private Date updateTime;
}
