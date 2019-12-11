package cn.ytcast.test;

import cn.ytcast.dao.AccountDao;
import cn.ytcast.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    @Test
    public void test() throws IOException {
        //加载配置文件
        InputStream is=Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建sqlsesson对象
        SqlSession sqlSession=new SqlSessionFactoryBuilder().build(is).openSession();
        //获取到代理对象
        AccountDao dao=sqlSession.getMapper(AccountDao.class);
        //查询所有数据
        List<Account> list=dao.findAll();
        for (Account a :list){
            System.out.println(a.toString());
        }
        //关闭资源
        sqlSession.close();
        is.close();
    }

    @Test
    public void test2() throws IOException {
        Account account=new Account();
        account.setName("1234");
        account.setMoney(123d);
        //加载配置文件
        InputStream is=Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建sqlsesson对象
        SqlSession sqlSession=new SqlSessionFactoryBuilder().build(is).openSession();
        //获取到代理对象
        AccountDao dao=sqlSession.getMapper(AccountDao.class);
        //保存数据
        dao.saveAccount(account);
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
        is.close();
    }
}
