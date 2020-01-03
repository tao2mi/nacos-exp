package com.ybq.controller;

import com.google.common.collect.Maps;
import com.ybq.feign.ServiceBFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author 87661
 */
@RequestMapping("/m")
@RestController
@RefreshScope
public class Server1Controller {

    @Value("${useLocalCache:'randomString'}")
    private String useLocalCache;

    @Autowired
    private ServiceBFeign serviceBFeign;

    @RequestMapping("/m1")
    public Object m1(String name) {
        Map<String, Object> m = Maps.newHashMap();
        m.put("name", name);
        m.put("useLocalCache", useLocalCache);
        return m;
    }

    @RequestMapping("/m2")
    public Object m2(String name) {
        Map<String, Object> m = Maps.newHashMap();
        m.put("name", serviceBFeign.b1(name));
        m.put("useLocalCache", useLocalCache);
        return m;
    }
}
