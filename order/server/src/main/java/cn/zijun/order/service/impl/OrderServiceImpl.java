package cn.zijun.order.service.impl;


import cn.zijun.order.dao.OrderDetailDao;
import cn.zijun.order.dao.OrderMasterDao;
import cn.zijun.order.dto.CartDTO;
import cn.zijun.order.dto.OrderDTO;
import cn.zijun.order.enums.OrderStatusEnum;
import cn.zijun.order.enums.PayStatusEnum;
import cn.zijun.order.enums.ResultEnum;
import cn.zijun.order.exception.OrderException;
import cn.zijun.order.pojo.OrderDetail;
import cn.zijun.order.pojo.OrderMaster;
import cn.zijun.order.pojo.ProductInfo;
import cn.zijun.order.service.OrderService;
import cn.zijun.order.utils.KeyUtil;
import cn.zijun.product.client.ProductClient;
import cn.zijun.product.common.DecreaseStockInput;
import cn.zijun.product.common.ProductInfoOutput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Title OrderServiceImpl
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/3
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterDao orderMasterDao;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO){

        /**查询商品（数量，价格）*/
        List<String>productIdList=orderDTO.getOrderDetailList().stream().map(e->e.getProductId()).collect(Collectors.toList());
        List<ProductInfoOutput> productInfoList = productClient.listForOrder(productIdList);
        String orderId= KeyUtil.genUniqueKey();
        if (productIdList==null){
            throw  new OrderException(ResultEnum.PARAM_ERROR);
        }

        /**写入订单数据库*/
        BigDecimal orderAmount=new BigDecimal(0);
        for (OrderDetail orderDetail:orderDTO.getOrderDetailList()){
            for (ProductInfoOutput productInfo:productInfoList){
                if (productInfo.getProductId().equals(orderDetail.getProductId())){
                    orderAmount=productInfo.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmount);
                    BeanUtils.copyProperties(productInfo,orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.genUniqueKey());
                    orderDetailDao.save(orderDetail);
                }
            }
        }

        /**库存更新*/
        List<DecreaseStockInput>decreaseStockInputList=orderDTO.getOrderDetailList().stream().
                map(e->new DecreaseStockInput(e.getProductId(),e.getProductQuantity()))
                .collect(Collectors.toList());

        productClient.decreaseStock(decreaseStockInputList);
        //List<CartDTO>cartDTOList=new ArrayList<>();
        OrderMaster orderMaster=new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterDao.save(orderMaster);
        return orderDTO;
    }

    @Override
    @Transactional
    public OrderDTO finish(String orderId) {
        Optional<OrderMaster> orderMasterOptional = orderMasterDao.findById(orderId);
        if (!orderMasterOptional.isPresent()){
            throw new OrderException(ResultEnum.ORDER_NOT_EXSIT);
        }
        OrderMaster orderMaster=orderMasterOptional.get();
        if (OrderStatusEnum.NEW.getCode().equals(orderMaster.getOrderStatus())){
            throw new OrderException(ResultEnum.ORDER_STATUS_ERROR);
        }
        orderMaster.setOrderStatus(OrderStatusEnum.FINISHED.getCode());

        List<OrderDetail> orderDetailList = orderDetailDao.findByOrderId(orderId);
        if (CollectionUtils.isEmpty(orderDetailList)){
            throw new OrderException(ResultEnum.ORDER_DETAIL_NOT_EXSIT);
        }
        OrderDTO orderDTO=new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
