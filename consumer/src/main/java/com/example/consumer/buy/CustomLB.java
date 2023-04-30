package com.example.consumer.buy;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;

@Service
public class CustomLB {
    private int turn = 0;
    @Autowired
    DiscoveryClient discoveryClient;
    public URI choose() {
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("PAYMENT");
        if(turn % 5 == 0){
            ++turn;
            return serviceInstances.get(1).getUri();
        } else {
            ++turn;
            return serviceInstances.get(0).getUri();
        }
    }
}
