package com.ybq.controller;

import com.google.common.collect.Maps;
import com.ybq.service.Service1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author 87661
 */
@RequestMapping("/b")
@RestController
@RefreshScope
public class Server2Controller {

    @Value("${useLocalCache:'randomString'}")
    private String useLocalCache;

    private final Service1 service1;

    public Server2Controller(Service1 service1) {
        this.service1 = service1;
    }

    @RequestMapping("/b1")
    public Object b1(String name) {
        Map<String, Object> m = Maps.newHashMap();
        m.put("name", service1.saySome(name));
        m.put("useLocalCache", useLocalCache);
        return m;
    }
}
