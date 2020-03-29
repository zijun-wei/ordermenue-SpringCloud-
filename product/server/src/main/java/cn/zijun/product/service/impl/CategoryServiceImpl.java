package cn.zijun.product.service.impl;

import cn.zijun.product.dao.ProductCategoryDao;
import cn.zijun.product.pojo.ProductCategory;
import cn.zijun.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title CategoryServiceImpl
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/3
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryDao productCategoryDao;
    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType) {
        return productCategoryDao.findByCategoryTypeIn(categoryType);
    }
}
