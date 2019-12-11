package test.aop; 

import entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;
import service.UserService;


/** 
* UserServiceLogger Tester. 
* 
* @author <Authors name> 
* @since <pre>10ÔÂ 14, 2019</pre> 
* @version 1.0 
*/ 
public class UserServiceLoggerTest { 

@Test
public void test() throws Exception {
    ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext2.xml");
    UserService userService=(UserService) context.getBean("userService");
    User user=new User();
    user.setId(1);
    user.setName("test");
    user.setPassword("123123");
    user.setEmail("yt@xxx.com");
    userService.addNewUser(user);
}

    @Test
    public void testP() throws Exception {
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext3.xml");
        User user=(User)context.getBean("user");
        UserService userService=(UserService)context.getBean("service");
        userService.addNewUser(user);
    }


    @Test
    public void testZhu() throws Exception {
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext5.xml");

        UserService userService=(UserService)context.getBean("userService");
        User user=new User();
        user.setId(1);
        user.setName("test");
        user.setPassword("123123");
        user.setEmail("yt@xxx.com");
        userService.addNewUser(user);

    }

} 
