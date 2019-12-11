package mapper;

import entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    public List<User> queryAll();
    public User queryByNameAndPwd(@Param("name") String name, @Param("pwd") String password);
    public int add(@Param("user")User user);
    public int update(Map<String,Object> map);
    public int delete(@Param("id")int id);
    public List<User> queryUserAndRole(@Param("id")int id);

}
