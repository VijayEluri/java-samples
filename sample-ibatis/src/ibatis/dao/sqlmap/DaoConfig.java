package ibatis.dao.sqlmap;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.DaoManagerBuilder;
public class DaoConfig {
    private static DaoManager daoManager;

    public static DaoManager getDaomanager() {
        if(daoManager == null){
            String resource = "ibatis/dao/sqlmap/dao.xml";
            try {
            Reader reader = Resources.getResourceAsReader(resource);
            daoManager = DaoManagerBuilder.buildDaoManager(reader);
            } catch( IOException e) {
                e.printStackTrace();
                throw new DaoException(e);
            }
            
        }
        return daoManager;
    }
}
