package com.example.consumer.buy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;

@Controller
@RequestMapping("")
@Slf4j
public class Buy {
    private static final String PAY_SERVICE = "http://PAYMENT";
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CustomLB customLB;
    @GetMapping("/buy")
    @ResponseBody
    public String buy4It(){
        URI balanceURI = customLB.choose();
        ResponseEntity<String>responseEntity = restTemplate.getForEntity(balanceURI+"/pay",String.class);
        return responseEntity.getBody();
    }
}
