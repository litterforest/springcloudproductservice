package com.softd.test.spring.cloud.productservice.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 功能描述
 *
 * @author cobee
 * @since 2020-09-25
 */
@Service
public class HelloService implements InitializingBean, DisposableBean {
    @Autowired
    private HiService hiService;
    @Autowired
    private HiService hiService1;

    public HelloService() {
        System.err.println("调用构造函数"+hiService);
    }

    public String sayHello(String name) {
        if (1 == 1) {
            throw new RuntimeException("服务层运行出错了");
        }
        return "hello " + name;
    }

//    @PostConstruct
//    void postConstruct() {
//        System.err.println("postConstruct()"+hiService);
//    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.err.println("afterPropertiesSet()" + hiService);
        System.err.println("afterPropertiesSet()1" + hiService1);
    }

//    @PreDestroy
//    void preDestroy() {
//        System.err.println("preDestroy()");
//    }

    @Override
    public void destroy() throws Exception {
        System.err.println("destroy()");
    }
}
