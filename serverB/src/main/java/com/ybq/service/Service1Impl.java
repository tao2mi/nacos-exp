package com.ybq.service;

import org.springframework.stereotype.Service;

@Service
public class Service1Impl implements Service1 {
    @Override
    public String saySome(String name) {
        return name + " from ServerB";
    }
}
