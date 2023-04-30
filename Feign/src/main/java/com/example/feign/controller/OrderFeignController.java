package com.example.feign.controller;

import com.example.feign.service.PaymentFeignService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("")
public class OrderFeignController {
    @Resource
    PaymentFeignService paymentFeignService;

    @GetMapping("/pay")
    @ResponseBody
    public String pay() {
        return paymentFeignService.pay4It();
    }
}
