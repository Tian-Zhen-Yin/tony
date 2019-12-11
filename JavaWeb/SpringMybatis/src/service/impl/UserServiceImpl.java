package service.impl;

import dao.UserMapper;
import org.apache.ibatis.session.SqlSessionException;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import pojo.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl  implements UserService {
    private UserMapper userMapper;
    @Override
    public List<User> findUsersWithConditions(User user) {
        try{
            return userMapper.getUserList(user);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
