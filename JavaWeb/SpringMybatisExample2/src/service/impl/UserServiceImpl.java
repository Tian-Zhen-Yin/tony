package service.impl;

import dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pojo.User;
import service.UserService;

import java.util.List;
@Transactional
@Service("userService")
public class UserServiceImpl  implements UserService {
    @Autowired
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

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public boolean addNewUser(User user) {
        boolean result=false;
        try{
            if(userMapper.add(user)==1){
                result=true;
            }
        }catch (RuntimeException e){
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
