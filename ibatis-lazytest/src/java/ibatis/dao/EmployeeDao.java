package ibatis.dao;

import ibatis.domain.Employee;

import java.util.List;


public interface EmployeeDao {
    public Employee getEmp(String id);

    public List getEmpList();    
}
