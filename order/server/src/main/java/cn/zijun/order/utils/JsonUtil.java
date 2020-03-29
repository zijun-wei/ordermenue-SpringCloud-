package cn.zijun.order.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

/**
 * @Title JsonUtil
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/5
 */
public class JsonUtil {

    private static ObjectMapper objectMapper=new ObjectMapper();
    private static Gson gson=new Gson();

    public static String toJson(Object object){
        try {
            String value = objectMapper.writeValueAsString(object);
            //gson.toJson(object);
            return value;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param message
     * @param typeToken  （返回list等使用）gson实现的type，
     *                   objectMapper用TypeReference typeReference。
     *                   普通类对象使用Class即可
     * @param <T>
     * @return
     */

    public static<T extends Object> T fromJson(String message, TypeToken<T>typeToken ){
        T object = gson.fromJson(message, typeToken.getType());
//        try {
//            objectMapper.readValue(message,typeReference);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return object;
    }
}
