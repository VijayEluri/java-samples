package ibatis.dao.sqlmap;

import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;

public abstract class BaseSqlMapDao extends SqlMapDaoTemplate {
    protected static final int PAGE_SIZE = 4;

    public BaseSqlMapDao(DaoManager daoManager) {
      super(daoManager);
    }
}
