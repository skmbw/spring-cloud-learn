package com.fuuzii;

import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;

/**
 * 根据正则表达式，进行路由过滤
 *
 * @author yinlei
 * @since 2018/9/10 14:46
 */
public class RouteRule {

    public PatternServiceRouteMapper serviceRouteMapper() {
        // servicePattern: 指的是微服务的pattern
        // routePattern: 指的是路由的pattern
        // 当你访问/microservice-provider-user/v1 其实就是
        // localhost:8040/v1/microservice-provider-user/user/1
        return new PatternServiceRouteMapper(
                "(?<name>^.+)-(?<version>v.+$)", "${version}/${name}");

    }
}
