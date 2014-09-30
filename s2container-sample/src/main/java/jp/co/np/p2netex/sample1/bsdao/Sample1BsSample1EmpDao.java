package jp.co.np.p2netex.sample1.bsdao;

import java.util.List;

import jp.co.np.p2netex.sample1.exentity.Sample1Sample1Emp;
import jp.co.np.p2netex.sample1.cbean.Sample1Sample1EmpCB;

/**
 * The dao interface of SAMPLE1_EMP.
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public interface Sample1BsSample1EmpDao extends jp.co.np.p2netex.sample1.allcommon.Sample1DaoWritable {

    public Class BEAN = Sample1Sample1Emp.class;// For S2Dao

    public static final String getCountAll_SQL = "select count(*) from SAMPLE1_EMP";
    public int getCountAll();
    
    public static final String getListAll_SQL = "select ID, NAME, HIRE_DATE, DEPT_ID, VERSION_NO from SAMPLE1_EMP";
    public java.util.List<Sample1Sample1Emp> getListAll();
    
    public static final String getEntity_SQL = "select ID, NAME, HIRE_DATE, DEPT_ID, VERSION_NO from SAMPLE1_EMP where SAMPLE1_EMP.ID = /*id*/null";
    public static final String getEntity_ARGS = "id";
    public Sample1Sample1Emp getEntity(java.lang.Integer id);


    public int selectCount(Sample1Sample1EmpCB cb);
    public List<Sample1Sample1Emp> selectList(Sample1Sample1EmpCB cb);

    public int insert(Sample1Sample1Emp entity);
    public int updateModifiedOnly(Sample1Sample1Emp entity);
    public int updateNonstrictModifiedOnly(Sample1Sample1Emp entity);
    public int delete(Sample1Sample1Emp entity);
    public int deleteNonstrict(Sample1Sample1Emp entity);

    public int[] insertList(List<Sample1Sample1Emp> entityList);
    public int[] updateList(List<Sample1Sample1Emp> entityList);
    public int[] updateListNonstrict(List<Sample1Sample1Emp> entityList);
    public int updateByQuery(Sample1Sample1EmpCB cb, Sample1Sample1Emp entity);// {DBFlute-0.7.5}
    public int[] deleteList(List<Sample1Sample1Emp> entityList);
    public int[] deleteListNonstrict(List<Sample1Sample1Emp> entityList);
    public int deleteByQuery(Sample1Sample1EmpCB cb);
}
