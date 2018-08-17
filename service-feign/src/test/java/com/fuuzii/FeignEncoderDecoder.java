package com.fuuzii;

import feign.Feign;

/**
 * @author yinlei
 * @since 2018/8/17 10:54
 */
public class FeignEncoderDecoder {

    public static void main(String[] args) {
        Feign.builder().decoder(null).encoder(null).target(null, "");
    }
}
