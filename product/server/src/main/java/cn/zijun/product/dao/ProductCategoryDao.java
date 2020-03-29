package cn.zijun.product.dao;

import cn.zijun.product.pojo.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Title ProductCategoryDao
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/2
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory,String> {
    public List<ProductCategory>findByCategoryTypeIn(List<Integer> categoryType);
}
