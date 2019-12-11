package cn.ytcast.test;

import cn.ytcast.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    @Test
    public void run1(){
        //加载配置
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取对象
        AccountService as=(AccountService)context.getBean("accountService",AccountService.class);
        //调用对象
        as.findAll();
    }
}
