package cn.zijun.product.dao;

import cn.zijun.product.pojo.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Title ProductInfoDao
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/2
 */
public interface ProductInfoDao extends JpaRepository<ProductInfo,String> {
    public List<ProductInfo> findByProductStatus(Integer productStatus);

    public List<ProductInfo>findByProductIdIn(List<String> ProductId);
}
