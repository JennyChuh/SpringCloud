package com.example.consumerhystrix.controller;

import com.example.consumerhystrix.service.PayService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.ws.rs.QueryParam;

@Controller
public class Payment {

    @Resource
    PayService payService;

    @GetMapping("/pay/ok")
    @ResponseBody
    public String pay(){
        return payService.pay();
    }

    @GetMapping("/pay/bad")
    @ResponseBody
    public String pay2(){
        return payService.pay2();
    }

    @GetMapping("/pay/global")
    @ResponseBody
    public String pay3(){
        return payService.pay3();
    }

    //服务熔断
    @GetMapping("/pay/breaker")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "circuitBreakerFallback", commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60")})
    public String circuitBreakerPay(@QueryParam("money") int money){
        if(money < 0){
            throw new RuntimeException("金额负数异常");
        }
        return "付款成功";
    }

    public String circuitBreakerFallback(int money){
        return "付账金额不能为负数(服务熔断)";
    }
}
