package com.example.paymenthystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.QueryParam;

@Service
@DefaultProperties(defaultFallback = "globalFallback")
public class Payment {
    public String normalPay(){
        return "正常返回";
    }

    @HystrixCommand(fallbackMethod = "payTimeoutHandler",commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000"),@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")})
    public String abnormalPay() throws InterruptedException {
        Thread.sleep(3000);
        return "异常返回";
    }

    public String payTimeoutHandler(){
        return "我是handler";
    }

    @HystrixCommand
    public String globalPay() throws InterruptedException {
        Thread.sleep(3000);
        return "异常返回(全局)";
    }

    public String globalFallback(){
        return "我是全局降级方法";
    }
}
