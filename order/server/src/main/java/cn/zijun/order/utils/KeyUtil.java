package cn.zijun.order.utils;

import java.util.Random;

/**
 * @Title KeyUtil
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/3
 */
public class KeyUtil {

    public static synchronized String genUniqueKey(){
        Random random=new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis()+String.valueOf(number);
    }
}
