package com.javafullstack.eureka_client_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/{id}")
    public String getCustomer(@PathVariable String id) {
        return String.format("Get customer with id %s", id);
    }
}
