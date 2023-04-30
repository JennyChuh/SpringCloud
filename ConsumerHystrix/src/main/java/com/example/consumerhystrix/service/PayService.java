package com.example.consumerhystrix.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "payment-hystrix",fallback = PayServiceFallback.class)
public interface PayService {
    @GetMapping("/pay")
    String pay();

    @GetMapping("/pay2")
    String pay2();

    @GetMapping("/pay3")
    String pay3();
}
