package com.fuuzii.service.impl;

import com.fuuzii.service.spi.HelloService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 断路器实现类
 *
 * @author yinlei
 * @since 2017/12/12 15:19
 */
@Service
public class HystrixHelloService implements HelloService {

    @Override
    public String sayHiFromClientOne(@RequestParam(value = "name") String name) {
        return "sorry " + name;
    }
}
