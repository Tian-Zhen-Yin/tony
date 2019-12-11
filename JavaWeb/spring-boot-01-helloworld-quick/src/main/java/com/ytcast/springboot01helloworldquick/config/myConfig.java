package com.ytcast.springboot01helloworldquick.config;

import com.ytcast.springboot01helloworldquick.service.HelloService;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration:指明当前类是一个配置类
 */
@Configuration
public class myConfig {
    //将方法的返回值添加到容器中：容器中这个组件的默认id是方法ming
    @Bean
    public HelloService helloService(){
            System.out.println("配置类@Bean给容器中添加组件");
            return new HelloService();
    }
}
