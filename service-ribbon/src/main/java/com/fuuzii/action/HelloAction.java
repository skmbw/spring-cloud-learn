package com.fuuzii.action;

import com.fuuzii.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 使用ribbon实现客户端负载均衡的服务
 *
 * @author yinlei
 * @since 2017/12/12 14:23
 */
@RestController
public class HelloAction {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService(name);
    }
}
