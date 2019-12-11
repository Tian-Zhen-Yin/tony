package cn.ytcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 账户
 */
@Controller("/account")
public class AccountController  {
    @RequestMapping("/findall")
    public String finaAll(){
        System.out.println("表现层:所有用户的信息");
        return "error";
    }
}
