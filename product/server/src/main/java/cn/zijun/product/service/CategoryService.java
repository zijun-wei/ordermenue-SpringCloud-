package cn.zijun.product.service;

import cn.zijun.product.pojo.ProductCategory;

import java.util.List;

/**
 * @Title CategoryService
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/3
 */
public interface CategoryService {
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType);
}
