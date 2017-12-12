package com.fuuzii.action;

import com.fuuzii.service.spi.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yinlei
 * @since 2017/12/12 14:35
 */
@RestController
public class HelloAction {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam String name) {
        return helloService.sayHiFromClientOne(name);
    }
}
