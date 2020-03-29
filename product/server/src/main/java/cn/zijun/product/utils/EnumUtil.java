package cn.zijun.product.utils;

import cn.zijun.product.enums.CodeEnum;

/**
 * @Title EnumUtil
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/2
 */
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code,Class<T>cs){
        for (T each:cs.getEnumConstants()){
            if (code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
