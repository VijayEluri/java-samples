package jp.canetrash.sample.ibatis3.service;


import static org.junit.Assert.*;
import jp.canetrash.sample.ibatis3.domain.Emp;
import jp.canetrash.sample.ibatis3.mapper.EmpMapper;

import org.junit.runner.RunWith;
import org.seasar.framework.unit.Seasar2;
import org.seasar.framework.unit.TestContext;

@RunWith(Seasar2.class)
public class EmpServiceTest {

    private EmpService empService;
    private TestContext ctx;
    private EmpMapper empMapper;

    public void testSimple() {
        assertNotNull(empService);
        empMapper.dropTable();
        empService.empMapper.createTable();
        assertNotNull(empService.empMapper.selectAllEmp());
        assertNotNull(empMapper);
        Emp entity = new Emp();
        entity.setId(1);
        entity.setName("テスト");
        entity.setTitle("タイトル");
        empMapper.insertEmp(entity);
        Emp emp = empMapper.selectOne(1);
        assertNotNull(emp);
        assertEquals("テスト", emp.getName());
    }
}
