package cn.zijun.product.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Title JsonUtil
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/5
 */
public class JsonUtil {

    private static ObjectMapper objectMapper=new ObjectMapper();

    public static String toJson(Object object){
        try {
            String value = objectMapper.writeValueAsString(object);
            return value;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
