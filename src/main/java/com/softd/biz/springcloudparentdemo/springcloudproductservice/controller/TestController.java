package com.softd.biz.springcloudparentdemo.springcloudproductservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述
 *
 * @author cobee
 * @since 2020-09-13
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getUserOrder/{orderId}")
    public Map<String, Object> getUserOrder(@PathVariable("orderId") String orderId){
        Map<String, Object> resultMap = new HashMap<>(2);
        resultMap.put("username", "cobee");
        String orderInfo = "";
        orderInfo = restTemplate.getForObject("http://orderservice/order/getOrder/{orderId}", String.class, orderId);
        resultMap.put("orderInfo", orderInfo);
        return resultMap;
    }
}
