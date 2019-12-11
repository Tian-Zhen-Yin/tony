package dao;

import pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    public List<User> getUserList(User user);
    public List<User> getUserListByMap(Map<String,String> map);
    public List<User> getUerListByName(String userName);
    public int add(User user);
    public int modify(User user);
    public int delete(int id);
}
