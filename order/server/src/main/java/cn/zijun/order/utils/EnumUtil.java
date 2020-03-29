package cn.zijun.order.utils;

import cn.zijun.order.enums.BaseEnum;

/**
 * @Title EnumUtil
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/3
 */
public class EnumUtil {
    public static <T extends BaseEnum> T getByCode(Integer code,Class<T>cs){
        for (T each:cs.getEnumConstants()){
            if (code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
