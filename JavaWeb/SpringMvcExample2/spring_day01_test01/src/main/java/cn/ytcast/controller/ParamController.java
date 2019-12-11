package cn.ytcast.controller;

import cn.ytcast.domain.Account;
import cn.ytcast.domain.User;
import org.apache.ibatis.annotations.Param;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 请求参数绑定
 */
@Controller
@RequestMapping("/param")
public class ParamController {
    /**
     * 参数绑定入门
     */
    @RequestMapping("/testParam")
    public String testParam(String username,String password){
        System.out.println("执行了");
        System.out.println(username+": "+password);
        return "success";
    }

    /**
     * 将请求数据封装到javabean中
     * @param account
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        System.out.println("执行了");
        System.out.println(account.toString());
        return "success";
    }

    /**
     * 自定义转换器
     * @param user
     * @return
     */
    @RequestMapping("/saveUser")
    public String saveAccount(User user){
        System.out.println("执行了");
        System.out.println(user);
        return "success";
    }
}
