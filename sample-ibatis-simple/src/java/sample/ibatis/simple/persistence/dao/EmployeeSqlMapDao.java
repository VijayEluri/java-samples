package sample.ibatis.simple.persistence.dao;

import java.util.List;

import com.ibatis.dao.client.DaoManager;


public class EmployeeSqlMapDao extends BaseSqlMapDao implements EmployeeDao {

    public EmployeeSqlMapDao(DaoManager daoManager) {
        super(daoManager);
    }

    public List getEmpList() {
        return queryForList("Employee.getEmployeeList", null);
    }
}
