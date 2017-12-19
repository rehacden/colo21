package com.colo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

    @PostMapping("/item/{code}/order")
    public String orderItem() {

        return "orderSuccessful";
    }
}
