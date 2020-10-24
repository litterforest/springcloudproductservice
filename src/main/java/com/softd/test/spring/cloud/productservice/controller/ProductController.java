package com.softd.test.spring.cloud.productservice.controller;

import com.softd.test.spring.cloud.productservice.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * 功能描述
 *
 * @author cobee
 * @since 2020-09-19
 */
@RestController
//@RequestMapping("/product")
@Slf4j
public class ProductController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/product/{productId}")
    public String getProduct(@PathVariable("productId") String productId) {
        return "Product["+ productId +"] Plain Info";
    }

    @GetMapping("/products")
    public List<String> list() {
        return Arrays.asList("123456", "12345a", "12345b", "12345c");
    }

    @PostMapping("/product")
    public String save(String productId, String productName) {
        return "save product: " + productId + ", " + productName + ", success!";
    }

    @DeleteMapping("/product/{productId}")
    public String delete(@PathVariable("productId") String productId) {
        return "delete product: " + productId + ", success";
    }

    @GetMapping("/getProductSingle")
    public String getProductSingle(@RequestParam("productId") String productId) {
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
