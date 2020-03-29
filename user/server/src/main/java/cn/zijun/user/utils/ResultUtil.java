package cn.zijun.user.utils;


import cn.zijun.user.enums.ResultEnum;
import cn.zijun.user.vo.ResultVO;

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

    public static ResultVO success(){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO error(ResultEnum resultEnum){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(resultEnum.getCode());
        resultVO.setMsg(resultEnum.getMessage());
        return resultVO;
    }
}
