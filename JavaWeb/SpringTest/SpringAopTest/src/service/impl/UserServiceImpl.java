package service.impl;

import dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
   // @Autowired
    private UserDao dao;
 /*   private String s1,s2;
    private int a=0;*/
    //无参构造
    public UserServiceImpl() {}
    //有参构造
  /*  public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }*/
    @Autowired
    public UserServiceImpl(UserDao dao) {
        this.dao = dao;

    }

  /*  public UserServiceImpl(UserDao dao,String s1) {
        this.dao = dao;
        this.s1=s1;
    }
    public UserServiceImpl(UserDao dao,int a) {
        this.dao = dao;
        this.a=a;
    }
    public UserServiceImpl(String s2,UserDao dao) {
        this.dao = dao;
        this.s1=s2;
    }

    public UserDao getDao() {
        return dao;
    }*/
/*

    public void setDao(UserDao dao) {
        this.dao = dao;
    }
*/

    @Override
    public void addNewUser(User user) {
        dao.save(user);
       /* System.out.println("s1="+s1);
        System.out.println("i1="+a);*/
    }
}
