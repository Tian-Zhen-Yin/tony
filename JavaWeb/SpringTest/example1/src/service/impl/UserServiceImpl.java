package service.impl;

import dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

    private UserDao dao;
    public UserServiceImpl() {}
    //¹¹Ôì×¢Èë
    @Autowired(required = false)
    public UserServiceImpl( @Qualifier("userDao")UserDao dao) {
        this.dao = dao;
    }

    @Override
    public void addNewUser(User user) {
        dao.save(user);

    }
}
