package com.itmuch.cloud.microservicesimpleprovidermovie.microservicesimpleconsumermovie.controller;

import com.itmuch.cloud.microservicesimpleprovidermovie.microservicesimpleconsumermovie.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${user.userServiceUrl}")
    private  String userServiceUrl;
    private  int b = 0;
    @GetMapping("/user/{id}")
    public User findByUser(@PathVariable Long id){

         return this.restTemplate.getForObject(this.userServiceUrl+id,User.class);

    }
}
