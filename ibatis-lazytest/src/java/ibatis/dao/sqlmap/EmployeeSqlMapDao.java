package ibatis.dao.sqlmap;

import ibatis.dao.EmployeeDao;
import ibatis.domain.Employee;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EmployeeSqlMapDao extends SqlMapClientDaoSupport implements EmployeeDao{

    public Employee getEmp(String id) {
        return (Employee)getSqlMapClientTemplate().queryForObject("Employee.getEmpByPk", id);
    }

    public List getEmpList() {
        return getSqlMapClientTemplate().queryForList("Employee.getEmpList", null);
    }


}
