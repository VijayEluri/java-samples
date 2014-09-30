package jp.canetrash.sample.ibatis3.service;

import java.util.List;

import jp.canetrash.sample.ibatis3.domain.Emp;
import jp.canetrash.sample.ibatis3.mapper.EmpMapper;

/**
 * @author tfunato
 * 
 */
public class EmpService {

    public EmpMapper empMapper;

    public List<Emp> selectALl() {
        List<Emp> selectAllEmp = empMapper.selectAllEmp();
        return selectAllEmp;
    }
}
