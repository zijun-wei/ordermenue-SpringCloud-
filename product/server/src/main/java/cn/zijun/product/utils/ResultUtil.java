package cn.zijun.product.utils;

import cn.zijun.product.vo.ResultVO;

/**
 * @Title ResultVOUtil
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/3
 */
public class ResultUtil {
    public static ResultVO success(Object result){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(result);
        return resultVO;
    }
}
