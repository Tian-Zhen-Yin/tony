package dao.impl;

import dao.UserDao;
import entity.User;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save(User user) {
        System.out.println("�����û���Ϣ�����ݿ�");

    }
}
