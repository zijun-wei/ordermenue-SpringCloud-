package cn.zijun.product.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title ServerController
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/3
 */
@RestController
@RequestMapping
public class ServerController {
    @RequestMapping("/msg")
    public String msg(){
        return "this is msg";
    }
}
