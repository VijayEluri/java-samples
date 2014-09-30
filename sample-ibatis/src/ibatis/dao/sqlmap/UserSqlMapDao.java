package ibatis.dao.sqlmap;

import ibatis.dao.UserDao;
import ibatis.domain.User;

import java.util.List;
import java.util.Map;

import com.ibatis.dao.client.DaoManager;

public class UserSqlMapDao extends BaseSqlMapDao implements UserDao{

    /**
     * @param daoManager
     */
    public UserSqlMapDao(DaoManager daoManager) {
        super(daoManager);
    }

    public User getUser(String id) {
        return (User)queryForObject("getUserByPk", id);
    }

    public List getUserList() {
        return queryForList("getUserList", null);
    }

    /* (”ñ Javadoc)
     * @see ibatis.dao.UserDao#callProcedure(java.util.Map)
     */
    public void callProcedure(Map map) {
        queryForObject("procedureCheck", map);
    }

    /* (”ñ Javadoc)
     * @see ibatis.dao.UserDao#transactionTest()
     */
    public void transactionTest() {
        User user = new User();
        user.setId("1");
        user.setName("test");
        user.setEmail("test@test.com");
        user.setPass("pass");

        try{
        daoManager.startTransaction();
        insert("insertUser", user);
        //daoManager.commitTransaction();
        //insert("insertUser", user);
        } finally {
            daoManager.endTransaction();    
        }
    }
    
    

}
