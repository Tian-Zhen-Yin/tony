package cn.ytcast.controller;

import cn.ytcast.domain.User;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"}) //把msg值存入session域中
public class AnnoController {
    @RequestMapping("/tessRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String uname) {
        System.out.println(uname);
        return "success";
    }

    /**
     * 获取到请求体的内容
     */
    @RequestMapping("/testRequestBody")
    public String tessRequestBody(@RequestBody String body) {
        System.out.println(body);
        return "success";
    }

    /**
     * 获取请求头的值
     */
    @RequestMapping("/testRequestHeader")
    public String testRquestHeader(@RequestHeader(value = "Accept") String header) {
        System.out.println(header);
        return "success";
    }

    /**
     * Cookie注解
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID", required = false) String cookieValue) {
        System.out.println(cookieValue);
        return "success";
    }

    /**
     * 接收请求的方法
     *
     * @param user
     * @return
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("1") User user) {
        System.out.println("执行了控制器的方法" + user.getUname() + user.getAge() + user.getDate());
        return "success";
    }

    /**
     * 被ModelAttribute修饰的方法,将会被先执行
     */
   /* @ModelAttribute
    public User showModel(String uname){
       User user=new User();
       user.setUname(uname);
       user.setAge(20);
       user.setDate(new Date());
       return user;
    }*/
    @ModelAttribute
    public void showModel(String uname, Map<String, User> map) {
        User user = new User();
        //对数据不为null的属性无用
        user.setUname("124");
        user.setAge(20);

        user.setDate(new Date());
        map.put("1", user);
    }

    /**
     * 设置session值，可以随着session的作用域而保存值。
     * @param model
     * @return
     */
    @RequestMapping("/testSessionAttribute")
    public String testSessionAttribute(Model model) {
        model.addAttribute("msg", "欧文");
        return "success";
    }

    /**
     * 得到session对象，获取session中值
     * @param model
     * @return
     */
    @RequestMapping("/getSessionAttribute")
    public String getSessionAttribute(ModelMap model) {
        String name = (String) model.get("msg");
        System.out.println(name);
        return "success";
    }

    @RequestMapping("/deleteSessionAttribute")
    public String deleteSessionAttribute(SessionStatus status) {
        //结束session对象
        status.setComplete();
        return "success";
    }

}
