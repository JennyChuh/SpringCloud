package com.example.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "payment")
@Component
public interface PaymentFeignService {
    @GetMapping("/pay")
    String pay4It();
}
