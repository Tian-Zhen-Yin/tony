package dao.impl;

import dao.UserDao;
import entity.User;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class UserDaoImpl2 implements UserDao {
    @Override
    public void save(User user) {
        System.out.println("Please output the information of User");
    }
}
