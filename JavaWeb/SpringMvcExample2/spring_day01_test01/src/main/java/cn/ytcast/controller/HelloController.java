package cn.ytcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//控制器
@Controller
@RequestMapping("/what")
public class HelloController {

  @RequestMapping(path="/hello")
    public String sayhello(){
        System.out.println("Hello SpringMvc");
        return "success";
    }
   @RequestMapping(path="/cn.ytcast.test",params = {"username=heihei"},headers = {"Accept"})
   public String test(){
       return "success";
   }
}
