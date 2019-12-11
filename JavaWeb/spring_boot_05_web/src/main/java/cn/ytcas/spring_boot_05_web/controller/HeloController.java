package cn.ytcas.spring_boot_05_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


@Controller
public class HeloController {
/*
    @RequestMapping({"/","/login.html"})
    public String index(){
        return "index";
    }*/
    @RequestMapping("/hello")
    public String success(Map<String,Object> map){
        map.put("hello","你好");
     return "success";
    }
}
