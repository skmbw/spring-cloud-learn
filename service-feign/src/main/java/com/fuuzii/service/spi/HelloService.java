package com.fuuzii.service.spi;

import com.fuuzii.service.impl.HystrixHelloService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 这个是使用feign调用真正的服务
 *
 * @author yinlei
 * @since 2017/12/12 14:33
 */
@FeignClient(value = "service-hi", fallback = HystrixHelloService.class) // 增加断路器，如果出现网络中断，将直接调用断路器服务
public interface HelloService {

    // 这里的url 就是要调用的服务的url，和方法名没有关系
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
