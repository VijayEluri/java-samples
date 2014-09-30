package sample.ibatis.simple.persistence.dao;

import java.util.List;


public class EmployeeSqlMapDaoTest extends DaoTestBase {

    /*
     * 'sample.ibatis.simple.persistence.dao.EmployeeSqlMapDao.getEmpList()' �̂��߂̃e�X�g�E���\�b�h
     */
    public void testGetEmpList() {
        EmployeeDao dao = (EmployeeDao)daoManager.getDao(EmployeeDao.class);
        List list = dao.getEmpList();
        assertEquals(14, list.size());
    }
}
