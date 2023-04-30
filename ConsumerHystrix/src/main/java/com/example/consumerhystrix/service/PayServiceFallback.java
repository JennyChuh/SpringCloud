package com.example.consumerhystrix.service;

import org.springframework.stereotype.Component;

@Component
public class PayServiceFallback implements PayService{
    @Override
    public String pay() {
        return "feign统一降级1";
    }

    @Override
    public String pay2() {
        return "feign统一降级2";
    }

    @Override
    public String pay3() {
        return "feign统一降级3";
    }
}
