package com.ybq.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "server2", fallback = ServiceBFeignFallback.class)
public interface ServiceBFeign {

    @RequestMapping("/b/b1")
    Object b1(@RequestParam("name")  String name);
}
