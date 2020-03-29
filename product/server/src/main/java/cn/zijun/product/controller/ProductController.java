package cn.zijun.product.controller;

import cn.zijun.product.common.DecreaseStockInput;
import cn.zijun.product.common.ProductInfoOutput;
import cn.zijun.product.dto.CartDTO;
import cn.zijun.product.pojo.ProductCategory;
import cn.zijun.product.pojo.ProductInfo;
import cn.zijun.product.service.CategoryService;
import cn.zijun.product.service.ProductService;
import cn.zijun.product.utils.ResultUtil;
import cn.zijun.product.vo.ProductInfoVO;
import cn.zijun.product.vo.ProductVO;
import cn.zijun.product.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Title ProductController
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/2
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    @CrossOrigin(allowCredentials = "true")//允许cookie跨域
    public ResultVO<List<ProductVO>>list(){
        List<ProductInfo>productInfoList=productService.findUpAll();

        List<Integer> categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        List<ProductVO>productVOList=new ArrayList<>();
        for (ProductCategory category:categoryList){
            ProductVO productVO=new ProductVO();
            productVO.setCategoryName(category.getCategoryName());
            productVO.setCategoryType(category.getCategoryType());
            List<ProductInfoVO>productInfoVOList=new ArrayList<>();
            for (ProductInfo productInfo:productInfoList){
                if (productInfo.getCategoryType().equals(category.getCategoryType())){
                    ProductInfoVO productInfoVO=new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultUtil.success(productVOList);
    }

    /**
     * 商品订单列表（给订单微服务使用）
     * @param productIdList
     * @return
     */
    @PostMapping("/listForOrder")
    public List<ProductInfoOutput>listForOrder(@RequestBody List<String>productIdList){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return productService.findList(productIdList);
    }

    @PostMapping("/decreaseStock")
    public  void decreaseStock(@RequestBody List<DecreaseStockInput>decreaseStockInputList){
        productService.decreaseStock(decreaseStockInputList);
    }
}
