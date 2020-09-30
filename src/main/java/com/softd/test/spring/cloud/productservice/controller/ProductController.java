package com.softd.test.spring.cloud.productservice.controller;

import com.softd.test.spring.cloud.productservice.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author cobee
 * @since 2020-09-19
 */
@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/getProduct/{productId}")
    public String getProduct(@PathVariable("productId") String productId) {
        return "Product["+ productId +"] Plain Info";
    }

    @GetMapping("/testErrorLog")
    public String testErrorLog() {
        try {
            helloService.sayHello("abc");
        } catch (Exception e) {
            log.error("param", e);
        }
        return "success";
    }

}
