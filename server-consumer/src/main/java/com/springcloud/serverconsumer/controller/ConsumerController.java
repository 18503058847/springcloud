package com.springcloud.serverconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Value("${url:http://172.22.1.120:8087}")
    private String url;


    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/say")
    public String say(){

        String msg = restTemplate.getForObject("http://provider-service/hello",
                String.class);

    //    restTemplate.getForObject("");
        return "say:" + msg;
    }
}
