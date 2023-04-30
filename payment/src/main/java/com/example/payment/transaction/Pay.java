package com.example.payment.transaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("")
@Slf4j
public class Pay implements PayServie {
    @GetMapping("/pay")
    @ResponseBody
    public String pay4It() throws InterruptedException {
        Thread.sleep(3000);
        return "我是Payment 1";
    }
}
