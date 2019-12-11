package test.pojo;

import dao.UserMapper;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import pojo.Address;
import pojo.User;
import util.MyBatisUtil;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
* User Tester. 
* 
* @author <Authors name> 
* @since <pre>10ÔÂ 9, 2019</pre> 
* @version 1.0 
*/ 
public class UserTest {
    private Logger logger=Logger.getLogger(UserTest.class);
    @Test
    public void testGetUserList() {
        SqlSession sqlSession=null;
        List<User> userList=new ArrayList<User>();
        try {
            sqlSession= MyBatisUtil.createSqlSession();
           /* user.setUserName("ÕÔ");
            user.setUserRole(3);*/
          /*  userList=sqlSession.getMapper(UserMapper.class).getUserList(user);*/
            String userName="";
            Integer roleId=3;
            userList=sqlSession.getMapper(UserMapper.class).getUserList(userName,roleId);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlsession(sqlSession);
        }
        logger.debug("Size============¡·£º"+userList.size());
       /* for(User use:userList){
            logger.debug("GetUserList-------------->"+use.getId()+","+use.getUserCode()+","+use.getUserName()+","
            +use.getUserRole()+","+use.getUserRoleName()+","+use.getPhone()+","+use.getGender());
        }*/
       for(User user:userList){
           logger.debug(""+user.getUserRole()+","+user.getGender());
       }



    }
    @Test
    public void testUpdatePassword(){
        logger.debug("TestUpdatePwd=============¡·");
        int count=0;
        SqlSession sqlSession=null;
        try{
            sqlSession=MyBatisUtil.createSqlSession();
            count=sqlSession.getMapper(UserMapper.class).updatePassword(2,"yty1123");
            sqlSession.commit();
        }catch (Exception e)
        {
            e.printStackTrace();
            sqlSession.rollback();
        }
        finally {
            logger.debug("TestUpdatePwd===>count:"+count);
            MyBatisUtil.closeSqlsession(sqlSession);
        }
    }
    @Test
    public void TestGetUserListByRoleId(){
        List<User> userList=null;
        SqlSession sqlSession=null;
        int roleId=3;
        try{
            sqlSession=MyBatisUtil.createSqlSession();
            userList=sqlSession.getMapper(UserMapper.class).getUserListByRoleId(roleId);
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            MyBatisUtil.closeSqlsession(sqlSession);
            for(User user:userList){
                logger.debug("TestGetUserListByRoleId------>"+"userName:"+user.getUserName()
                +"Role:"+user.getRole().getId()
                +"---"+user.getRole().getRoleName()
                +"---"+user.getRole().getRoleCode());
            }
        }
    }
    @Test
    public void TestGetAddressListByUserId(){
        List<User> userList=null;
        SqlSession sqlSession=null;
        int id=1;
        logger.debug("GetAddress:=========>");
        try{

            sqlSession=MyBatisUtil.createSqlSession();
            userList=sqlSession.getMapper(UserMapper.class).getAddressListByUserId(id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlsession(sqlSession);
        }
        for(User user:userList){
            logger.debug("userList(include:addresslist)======>userCode:"
            +user.getUserCode()+",userName:"+user.getUserName());

            for (Address address:user.getAddressList()){
                logger.debug("address---->id:"+address.getId()
                                +",contact:"+address.getContact()
                                +",addressDesc:"+address.getAddressDesc()
                                +",tel:"+address.getTel()
                                +",postCode:"+address.getPostCode());
            }
        }
    }
    @Test
    public void testGetUserByRoleId_foreach_array(){
        SqlSession sqlSession=null;
        List<User> userList=new ArrayList<User>();

        Integer[] roleIds={2,3};
        try{
            sqlSession=MyBatisUtil.createSqlSession();
            userList=sqlSession.getMapper(UserMapper.class).getUserByRoleId_foreach_array(roleIds);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlsession(sqlSession);
        }
        logger.debug("Size============¡·£º"+userList.size());
        for(User user:userList){
            logger.debug("user------>"+user.getId()+","+user.getUserCode()+","+user.getUserName()+","
            +user.getUserRole());
        }
    }
    @Test
    public void testGetUserByRoleId_foreach_list(){
        SqlSession sqlSession=null;
        List<User> userList=new ArrayList<User>();

        List<Integer> roleLists=new ArrayList<Integer>();
        roleLists.add(2);
        roleLists.add(1);
        try{
            sqlSession=MyBatisUtil.createSqlSession();
            userList=sqlSession.getMapper(UserMapper.class).getUserByRoleId_foreach_list(roleLists);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlsession(sqlSession);
        }
        logger.debug("Size============¡·£º"+userList.size());
        for(User user:userList){
            logger.debug("user------>"+user.getId()+","+user.getUserCode()+","+user.getUserName()+","
                    +user.getUserRole());
        }
    }

    @Test
    public void testGetUserByRoleId_foreach_map(){
        SqlSession sqlSession=null;
        List<User> userList=new ArrayList<User>();
        Map<String,Object> conditionMap=new HashMap<String, Object>();
        List<Integer> roleLists=new ArrayList<Integer>();
        roleLists.add(2);
        roleLists.add(1);
        conditionMap.put("gender",1);
        conditionMap.put("roleIds",roleLists);
        try{
            sqlSession=MyBatisUtil.createSqlSession();
            userList=sqlSession.getMapper(UserMapper.class).getUserByRoleId_foreach_map(conditionMap);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlsession(sqlSession);
        }
        logger.debug("Size============¡·£º"+userList.size());
        for(User user:userList){
            logger.debug("user------>"+user.getId()+","+user.getUserCode()+","+user.getUserName()+","
                    +user.getUserRole());
        }
    }

} 
