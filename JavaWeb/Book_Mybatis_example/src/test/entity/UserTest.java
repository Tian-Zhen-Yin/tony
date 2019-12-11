package test.entity; 

import entity.User;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/** 
* User Tester. 
* 
* @author <Authors name> 
* @since <pre>10‘¬ 27, 2019</pre> 
* @version 1.0 
*/ 
public class UserTest {
    SqlSession sqlSession=null;
    UserMapper mapper=null;
@Before
public void before(){
    try {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(is);
        sqlSession=factory.openSession();
        mapper=sqlSession.getMapper(UserMapper.class);
    } catch (IOException e) {
        e.printStackTrace();
    }

}
@Test
public void testUser() throws IOException {

    List<User> list=mapper.queryAll();
    System.out.println(list);
}
@Test
public void testQueryUser() throws IOException{

    User user=mapper.queryByNameAndPwd("admin","123456");
    System.out.println(user);
}
@Test
public void testAdd() throws Exception{
    User user=new User();
    user.setName("’‘ŒÂ");
    user.setPassword("123123");
    user.setAge(32);
    user.setSex(1);
    mapper.add(user);
}
@Test
public void testUpdate() throws Exception{
   Map<String,Object> map=new HashMap<>();
   map.put("id",3);
   map.put("name","1234");
   map.put("password","admin1234");
   map.put("age",12);
   map.put("sex",1);
   mapper.update(map);
}
@Test
public void testDelete() throws Exception{
  int id=3;
  mapper.delete(id);
}
@Test
public void testQueryUserAndRole() throws Exception{
    int id=2;
    List<User> list=mapper.queryUserAndRole(id);
    System.out.println(list);
}
@After
public void after(){
    sqlSession.commit();
    sqlSession.close();
}

} 
