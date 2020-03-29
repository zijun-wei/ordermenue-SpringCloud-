package cn.zijun.order.convert;

import cn.zijun.order.dto.OrderDTO;
import cn.zijun.order.enums.ResultEnum;
import cn.zijun.order.exception.OrderException;
import cn.zijun.order.form.OrderForm;
import cn.zijun.order.pojo.OrderDetail;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title OrderForm2OrderDTO
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/3
 */
@Slf4j
public class OrderForm2OrderDTO {

    public static OrderDTO convert(OrderForm orderForm){
        OrderDTO orderDTO=new OrderDTO();
        Gson gson=new Gson();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenId(orderForm.getOpenid());
        List<OrderDetail> orderDetailList=new ArrayList<>();

        try{
            orderDetailList=gson.fromJson(orderForm.getItems(),new TypeToken<List<OrderDetail>>(){}.getType());
        }catch (Exception e){
            log.error("【json转换】错误，string={}",orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
