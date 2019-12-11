package dao;

import org.apache.ibatis.annotations.Param;
import pojo.Address;
import pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    public List<User> getUserList(@Param("userName")String userName,@Param("userRole")Integer roleId);
    public int updatePassword(@Param("id")Integer id,@Param("pwd")String pwd);
    //���ݽ�ɫid����ȡ�û��б�
    public List<User> getUserListByRoleId(@Param("userRole")Integer roleId);
    //�û���ַ�б�
    public List<User> getAddressListByUserId(@Param("id")Integer userId);

    public List<User> getUserByRoleId_foreach_array(Integer[] roleIds);
    public List<User> getUserByRoleId_foreach_list(List<Integer> roleList);
    public List<User> getUserByRoleId_foreach_map(Map<String,Object> conditionMap);


}
