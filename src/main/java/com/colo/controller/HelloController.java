package com.colo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "homepage";
    }

    @RequestMapping("/map")
    public String map() {
        return "map";
    }

    @RequestMapping("/map2")
    public String map2() {
        return "map2";
    }

}