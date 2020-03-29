package cn.zijun.product.service.impl;

import cn.zijun.product.common.DecreaseStockInput;
import cn.zijun.product.common.ProductInfoOutput;
import cn.zijun.product.dao.ProductInfoDao;
import cn.zijun.product.dto.CartDTO;
import cn.zijun.product.enums.ProductStatusEnum;
import cn.zijun.product.enums.ResultEnum;
import cn.zijun.product.exception.ProductException;
import cn.zijun.product.pojo.ProductInfo;
import cn.zijun.product.service.ProductService;
import cn.zijun.product.utils.JsonUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Title ProductServiceImpl
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/3
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoDao productInfoDao;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoDao.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfoOutput> findList(List<String>productIdList) {
        return productInfoDao.findByProductIdIn(productIdList).stream().map(e->{
            ProductInfoOutput output=new ProductInfoOutput();
            BeanUtils.copyProperties(e,output);
            return output;
        }).collect(Collectors.toList());
    }

    @Override
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {

        List<ProductInfo>productInfoList=decreaseStockProcess(decreaseStockInputList);
        List<ProductInfoOutput> productInfoOutputList = productInfoList.stream().map(e -> {
            ProductInfoOutput productInfoOutput = new ProductInfoOutput();
            BeanUtils.copyProperties(e, productInfoOutput);
            return productInfoOutput;
        }).collect(Collectors.toList());
        amqpTemplate.convertAndSend("productInfo", JsonUtil.toJson(productInfoOutputList));
    }

    @Transactional(rollbackFor = Exception.class)
    public List<ProductInfo> decreaseStockProcess(List<DecreaseStockInput> decreaseStockInputList) {

        List<ProductInfo>productInfoList=new ArrayList<>();

        for (DecreaseStockInput decreaseStockInput:decreaseStockInputList){
            Optional<ProductInfo> productInfoOptional = productInfoDao.findById(decreaseStockInput.getProductId());
            if (!productInfoOptional.isPresent()){
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            ProductInfo productInfo=productInfoOptional.get();
            int stock = productInfo.getProductStock() - decreaseStockInput.getProductQuantity();
            if (stock<0){
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(stock);
            productInfoDao.save(productInfo);

            productInfoList.add(productInfo);
        }
        return productInfoList;
    }

}
