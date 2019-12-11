package cn.ytcast.controller;

import cn.ytcast.domain.Account;
import cn.ytcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.print.DocFlavor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController  {
    @Autowired
    private AccountService accountService;
    @RequestMapping("/findall")
    public String finaAll(Model model){
        System.out.println("表现层:所有用户的信息");
        //调用service方法
        List<Account> list=accountService.findAll();
        model.addAttribute("list",list);
        return "success";
    }

    @RequestMapping("/save")
    public void savel(Account account, HttpServletRequest request,HttpServletResponse response) throws IOException {
        accountService.saveAccount(account);
        //重定向
        response.sendRedirect(request.getContextPath()+"/account/findall");
        return ;
    }
}
