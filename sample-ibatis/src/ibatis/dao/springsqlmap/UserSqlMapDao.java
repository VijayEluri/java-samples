/*
 * çÏê¨ì˙: 2005/02/15
 */
package ibatis.dao.springsqlmap;

import ibatis.dao.UserDao;
import ibatis.domain.User;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * @author funato
 */
public class UserSqlMapDao extends SqlMapClientDaoSupport implements UserDao {

    public User getUser(String id) {
        return (User) getSqlMapClientTemplate().queryForObject("getUserByPk", id);
    }

    public List getUserList() {
        return getSqlMapClientTemplate().queryForList("getUserList", null);
    }

    /* (îÒ Javadoc)
     * @see ibatis.dao.UserDao#callProcedure(java.util.Map)
     */
    public void callProcedure(Map map) {
        getSqlMapClientTemplate().queryForObject("swapParameters", map);
    }

    /* (îÒ Javadoc)
     * @see ibatis.dao.UserDao#transactionTest()
     */
    public void transactionTest() {
        throw new RuntimeException("not implemented yet.");
        
    }


}
