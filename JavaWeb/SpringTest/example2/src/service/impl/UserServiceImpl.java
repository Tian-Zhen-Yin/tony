package service.impl;

import dao.UserDao;
import entity.User;
import org.springframework.stereotype.Service;
import service.UserService;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    /**
     * Resource注解实现组件装配，在默认情况下按set名匹配，无法应用在构造方法中
     * 因此，需要构造注入的还是选择Autowried 自动装配注解
     * @param userDao
     */
    @Resource(name="userDao")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl() {}
    //构造注入

    public UserServiceImpl( UserDao dao) {
        this.userDao = dao;
    }

    @Override
    public void addNewUser(User user) {
        userDao.save(user);

    }
}
