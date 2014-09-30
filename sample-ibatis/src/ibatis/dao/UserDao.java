package ibatis.dao;

import ibatis.domain.User;

import java.util.List;
import java.util.Map;


public interface UserDao {
    public User getUser(String id);

    public List getUserList();
    
    public void callProcedure(Map map);
    
    public void transactionTest();
}
