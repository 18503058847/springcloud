package com.springcloud.serverconsumer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {


    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/say")
    public String say(){

        String msg = restTemplate.getForEntity("http://PROVIDER-SERVICE/hello",
                String.class).getBody();

    //    restTemplate.getForObject("");
        return "say:" + msg;
    }
}
