package jp.canetrash.sample.ibatis3.mapper;

import java.util.List;

import jp.canetrash.sample.ibatis3.domain.Emp;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface EmpMapper {

    @Select("SELECT * FROM emp ")
    List<Emp> selectAllEmp();

    Emp selectEmp(int id);

    @Insert("insert into emp (id, name, title ) values (#{id}, #{name}, #{title})")
    void insertEmp(Emp emp);

    @Delete("delete from emp where id = #{id}")
    int deleteEmp(int id);

    int updateEmp(Emp emp);

    @Update("create table emp (id integer, name varchar(128), title varchar(128)) ")
    void createTable();

    @Update("drop table emp")
    void dropTable();
    
    Emp selectOne(int id);
}
