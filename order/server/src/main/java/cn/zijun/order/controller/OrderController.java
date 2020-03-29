package cn.zijun.order.controller;

import cn.zijun.order.dto.CartDTO;
import cn.zijun.order.dto.OrderDTO;
import cn.zijun.order.enums.ResultEnum;
import cn.zijun.order.exception.OrderException;
import cn.zijun.order.form.OrderForm;
import cn.zijun.order.pojo.ProductInfo;
import cn.zijun.order.service.OrderService;
import cn.zijun.order.convert.OrderForm2OrderDTO;
import cn.zijun.order.utils.ResultUtil;
import cn.zijun.order.vo.ResultVO;
import cn.zijun.product.client.ProductClient;
import cn.zijun.product.common.DecreaseStockInput;
import cn.zijun.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title OrderController
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/3
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductClient productClient;

    @PostMapping("/create")
    public ResultVO create(@Valid OrderForm orderForm, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确,orderForm={}",orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO= OrderForm2OrderDTO.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】购物车信息为空");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }
        orderService.create(orderDTO);
        Map<String,String>map=new HashMap<>();
        map.put("orderId",orderDTO.getOrderId());
        return ResultUtil.success(map);
    }

    @GetMapping("/getProductList")
    public String getProductList(){
        List<ProductInfoOutput> productInfoList = productClient.listForOrder(Arrays.asList("123456"));
        log.info("response={}",productInfoList);
        return "ok";
    }
    @GetMapping("/getDecreaseStock")
    public String getDecreaseStock(){
        productClient.decreaseStock(Arrays.asList(new DecreaseStockInput("123456",2)));
        return "ok";
    }

    @PostMapping("/finish")
    public ResultVO<OrderDTO>finish(@RequestParam("orderId")String orderId){
        return ResultUtil.success(orderService.finish(orderId));
    }
}
