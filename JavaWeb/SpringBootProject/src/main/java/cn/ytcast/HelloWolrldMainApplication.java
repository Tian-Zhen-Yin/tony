package cn.ytcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 来标注一个主程序，说明这是一个Spring Boot应用
 */
@SpringBootApplication
public class HelloWolrldMainApplication {
    public  static  void main(String[] args){
        //启动Spring应用程序
        SpringApplication.run(HelloWolrldMainApplication.class,args);
    }
}
