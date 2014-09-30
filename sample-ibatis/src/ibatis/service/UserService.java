package ibatis.service;

import ibatis.dao.UserDao;
import ibatis.dao.sqlmap.DaoConfig;
import ibatis.domain.User;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ibatis.dao.client.DaoManager;

public class UserService {
    private static final UserService service = new UserService();
    private DaoManager daoManager = DaoConfig.getDaomanager();
    private UserDao userDao;

    public UserService() {
        userDao = (UserDao)daoManager.getDao(UserDao.class);
    }

    public static UserService getInstance() {
        return service;
    }

    public User getUserByPk(String id) {
        return userDao.getUser(id);
    }

    public List getUserList() {
        return userDao.getUserList();
    }

    public void callProcedure(Map map ){
        userDao.callProcedure(map);
    }
    
    /**** Spring Related ****/
    public static UserService getInitSpringInstance(){
        service.userDao = getUserDao();
        return service;
    }

    protected static UserDao getUserDao() {
        ApplicationContext context =
            new FileSystemXmlApplicationContext("bin/ibatis/dao/springsqlmap/applicationContext.xml");
        return (UserDao)context.getBean("userDao");
    }
}
