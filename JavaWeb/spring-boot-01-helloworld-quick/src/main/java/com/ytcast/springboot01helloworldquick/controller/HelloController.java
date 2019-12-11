package com.ytcast.springboot01helloworldquick.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/*@ResponseBody
@Controller*/
@RestController
public class HelloController {
    @Value("${person.last-name}")
    String name;
    @RequestMapping("/sayHello")
    public String sayhello(){
        return "Hello!"+name;
    }

}
