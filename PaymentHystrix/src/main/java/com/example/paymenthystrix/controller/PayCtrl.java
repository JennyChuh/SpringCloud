package com.example.paymenthystrix.controller;

import com.example.paymenthystrix.service.Payment;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.QueryParam;

@Controller
public class PayCtrl {

    @Autowired
    Payment payment;

    @GetMapping("/pay")
    @ResponseBody
    public String pay(){
        return payment.normalPay();
    }

    @GetMapping("/pay2")
    @ResponseBody
    public String payAbnormal() throws InterruptedException {
        return payment.abnormalPay();
    }

    @GetMapping("/pay3")
    @ResponseBody
    public String payGlobal() throws InterruptedException {
        return payment.globalPay();
    }
}
