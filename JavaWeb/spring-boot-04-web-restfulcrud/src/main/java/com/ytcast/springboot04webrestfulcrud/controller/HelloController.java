package com.ytcast.springboot04webrestfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/fail")
    public String hello(){
        return "Hello World";
    }

    //查处一些数据，在页面展示

    @RequestMapping("/hello")
    public String success(){
        return "success";
    }
}
