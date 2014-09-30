package ibatis.dao.sqlmap;

import ibatis.dao.DepartmentDao;
import ibatis.domain.Department;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * @author
 * @ibatis.sql-map
 * namespace="Department"
 */
public class DepartmentSqlMapDao extends SqlMapClientDaoSupport implements DepartmentDao {

    /**
     * @ibatis.select id="getDptByPk" result-class="ibatis.domain.Department"
     *  sql="select CODE, DPTNAME FROM DEPARTMENT WHERE CODE = #value#"
     */
    public Department getDpt(String id) {
        return (Department)getSqlMapClientTemplate().queryForObject("Department.getDptByPk", id);
    }

    /**
     * @ibatis.select id="getDptList"
     *  sql="select CODE, DPTNAME FROM DEPARTMENT ORDER BY CODE"
     */
    public List getDptList() {
        return getSqlMapClientTemplate().queryForList("Department.getDptList", null);
    }

}
