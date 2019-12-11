package service;

import pojo.User;

import java.util.List;

public interface UserService {
    public List<User> findUsersWithConditions(User user);
}
