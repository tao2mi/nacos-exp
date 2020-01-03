package com.ybq.feign;

public class ServiceBFeignFallback {


    Object b1(String name) {
        return name + " from fallback";
    }
}
