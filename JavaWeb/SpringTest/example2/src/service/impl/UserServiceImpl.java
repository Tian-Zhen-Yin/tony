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
     * Resourceע��ʵ�����װ�䣬��Ĭ������°�set��ƥ�䣬�޷�Ӧ���ڹ��췽����
     * ��ˣ���Ҫ����ע��Ļ���ѡ��Autowried �Զ�װ��ע��
     * @param userDao
     */
    @Resource(name="userDao")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl() {}
    //����ע��

    public UserServiceImpl( UserDao dao) {
        this.userDao = dao;
    }

    @Override
    public void addNewUser(User user) {
        userDao.save(user);

    }
}
