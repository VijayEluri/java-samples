package ibatis.dao;

import ibatis.domain.Department;

import java.util.List;


public interface DepartmentDao {
    public Department getDpt(String id);

    public List getDptList();    
}
