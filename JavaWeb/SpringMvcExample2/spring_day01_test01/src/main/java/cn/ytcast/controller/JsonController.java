package cn.ytcast.controller;

import cn.ytcast.domain.Account;
import cn.ytcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/jsonController")
public class JsonController {
    @RequestMapping("/testResponseJson")
    public @ResponseBody Account testResponseJson(@RequestBody Account account) {
        System.out.println("异步请求："+account);
        account.setUsername("hahaha");
        account.setPassword("3456");
        account.setMoney("222");
        return account;
    }

    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax方法执行了。。。");
        System.out.println(user);
        //做相应，模拟查询数据库
        user.setUname("HAHA");
        user.setAge(22);
        user.setDate(new Date());
        return user;
    }
}
