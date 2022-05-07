package com.hello.order.controller;


import com.hello.order.entity.TOrder;
import com.hello.order.service.ITOrderService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author system
 * @since 2022-04-30
 */
@Slf4j
@RestController
@RequestMapping("/api")
@DefaultProperties(defaultFallback = "createOrderErrorGlobal") // 开启全局降级方法，可不带参数！！！
public class TOrderController {

    @Autowired
    private ITOrderService itOrderService;

//    @HystrixCommand(fallbackMethod = "createOrderError") // 指定降级方法，参数需要和主方法一致！！！
    @HystrixCommand
    @PostMapping("/order")
    public Object create(@RequestBody TOrder order){
        return itOrderService.create(order);
    }

    // 指定熔断方法
    public Object createOrderError(@RequestBody TOrder order){
        log.info(" 创建订单异常！ ===> order:{}",order);
        Map<String,Object> err_map = new HashMap<>();
        err_map.put("code",500);
        err_map.put("msg","创建订单异常！");
        return err_map;
    }

    // 全局熔断方法
    public Object createOrderErrorGlobal(){
        Map<String,Object> err_map = new HashMap<>();
        err_map.put("code",500);
        err_map.put("msg","创建订单异常！");
        return err_map;
    }

}
