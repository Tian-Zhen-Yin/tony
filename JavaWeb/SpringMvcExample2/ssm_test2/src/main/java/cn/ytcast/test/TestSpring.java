package cn.ytcast.test;

import cn.ytcast.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    @Test
    public void test1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountServiceImpl al=(AccountServiceImpl)context.getBean("accountService");
        al.findAll();
    }
}
