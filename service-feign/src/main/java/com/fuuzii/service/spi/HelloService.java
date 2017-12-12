package com.fuuzii.service.spi;

import com.fuuzii.service.impl.HystrixHelloService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yinlei
 * @since 2017/12/12 14:33
 */
@FeignClient(value = "service-hi", fallback = HystrixHelloService.class) // 增加断路器
public interface HelloService {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
