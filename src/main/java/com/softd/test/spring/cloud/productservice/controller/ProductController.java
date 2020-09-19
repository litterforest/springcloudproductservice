package com.softd.test.spring.cloud.productservice.controller;

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
public class ProductController {

    @GetMapping("/getProduct/{productId}")
    public String getProduct(@PathVariable("productId") String productId) {
        return "Product["+ productId +"] Plain Info";
    }

}
