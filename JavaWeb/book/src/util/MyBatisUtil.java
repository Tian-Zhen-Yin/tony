package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.lf5.util.Resource;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    private static SqlSessionFactory factory;
    static {

        try {
            //1获取mybatis-config.xml的输入流
            InputStream is= Resources.getResourceAsStream("mybatis-config.xml");
            //创建SqlSessionFactoru对象，完成对配置文件的速去
            factory=new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession createSqlSession(){
        //false表示关闭事务控制，默认市true
        return factory.openSession(false);
    }
    public static void closeSqlsession(SqlSession sqlSession){
        if(null!=sqlSession){
            sqlSession.close();
        }
    }
}
