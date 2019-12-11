package dao.impl;

import dao.UserMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import pojo.User;

import java.sql.SQLClientInfoException;
import java.util.List;

public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper {
    private SqlSessionTemplate sqlSession;

    @Override
    public List<User> getUserList(User user) {
        return this.getSqlSession().selectList("dao.UserMapper.getUserList",user);
    }

/*    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }
*/
}
