package com.ytcast.springboot01helloworldquick.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 将配置文件中配置的每一个属性的值，映射到这个组件中
 * @ConfigurationProperties:告诉Springboot 将本类中所有属性和配置文件中相关的配置进行绑定
 * prefix:配置文件中那个下面的所有属性进行一一映射
 *
 * 只有这个组件是容器中的组件，才能提供@ConfigurationProperties的功能
 *
 *
 * @Validated 校验
 */
/*@PropertySource(value = {"classpath:person.properties"})*/
@Component
@ConfigurationProperties(prefix = "person")
public class Person {
    /**
     * <bean class="Person">
     *     <property name="lastname" value=""></property>
     *     </bean>
     */
   //@Value("${person.last-name}")
     //lastName为email类型
    //@Email
    private String lastName;
   //@Value("#{11*2}")
    private Integer age;
    //@Value("true")
    private Boolean boss;
    private Date birth;

    private Map<String,Object> maps;
    private List<Object> lsts;
    private Dog dog;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLsts() {
        return lsts;
    }

    public void setLsts(List<Object> lsts) {
        this.lsts = lsts;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lsts=" + lsts +
                ", dog=" + dog +
                '}';
    }
}
