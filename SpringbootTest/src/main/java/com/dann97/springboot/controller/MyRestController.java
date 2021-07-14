package com.dann97.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class MyRestController {
    @GetMapping(path = "/my-path")
    public List<String> myMethod() {
        return Arrays.asList("hello", "world");
    }

    @GetMapping(path = "/my-path-two")
    public List<String> myMethod(@RequestParam("param") String param, @RequestParam("param2") String param2) {
        return Arrays.asList("hello", "world", param, param2);
    }

    @GetMapping(path = "/my-path-two/{param}")
    public List<String> myMethodPathVariable(@PathVariable("param") String param) {
        return Arrays.asList("hello", "world", param);
    }
}
