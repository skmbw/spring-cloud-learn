package com.fuuzii;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.client.ClientHttpResponse;

/**
 * @author yinlei
 * @since 2018/9/10 14:54
 */
public class UserFallBackProvider implements FallbackProvider {

    @Override
    public ClientHttpResponse fallbackResponse(Throwable cause) {
        return null;
    }

    @Override
    public String getRoute() {
        return null;
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return null;
    }
}
