package ibatis.service;

import ibatis.dao.EmployeeDao;

import ibatis.domain.Employee;

import java.util.List;


public class EmployeeService {
    private EmployeeDao empDao;

    public void setEmpDao(EmployeeDao empDao) {
        this.empDao = empDao;
    }

    public Employee getEmpByPk(String id) {
        return empDao.getEmp(id);
    }

    public List getEmpList() {
        return empDao.getEmpList();
    }
}
