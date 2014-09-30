package jp.co.np.p2netex.sample2.bsdao;

import java.util.List;

import jp.co.np.p2netex.sample2.exentity.Sample2Sample2Emp;
import jp.co.np.p2netex.sample2.cbean.Sample2Sample2EmpCB;

/**
 * The dao interface of SAMPLE2_EMP.
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public interface Sample2BsSample2EmpDao extends jp.co.np.p2netex.sample2.allcommon.Sample2DaoWritable {

    public Class BEAN = Sample2Sample2Emp.class;// For S2Dao

    public static final String getCountAll_SQL = "select count(*) from SAMPLE2_EMP";
    public int getCountAll();
    
    public static final String getListAll_SQL = "select ID, NAME, HIRE_DATE, DEPT_ID, VERSION_NO from SAMPLE2_EMP";
    public java.util.List<Sample2Sample2Emp> getListAll();
    
    public static final String getEntity_SQL = "select ID, NAME, HIRE_DATE, DEPT_ID, VERSION_NO from SAMPLE2_EMP where SAMPLE2_EMP.ID = /*id*/null";
    public static final String getEntity_ARGS = "id";
    public Sample2Sample2Emp getEntity(java.lang.Integer id);


    public int selectCount(Sample2Sample2EmpCB cb);
    public List<Sample2Sample2Emp> selectList(Sample2Sample2EmpCB cb);

    public int insert(Sample2Sample2Emp entity);
    public int updateModifiedOnly(Sample2Sample2Emp entity);
    public int updateNonstrictModifiedOnly(Sample2Sample2Emp entity);
    public int delete(Sample2Sample2Emp entity);
    public int deleteNonstrict(Sample2Sample2Emp entity);

    public int[] insertList(List<Sample2Sample2Emp> entityList);
    public int[] updateList(List<Sample2Sample2Emp> entityList);
    public int[] updateListNonstrict(List<Sample2Sample2Emp> entityList);
    public int updateByQuery(Sample2Sample2EmpCB cb, Sample2Sample2Emp entity);// {DBFlute-0.7.5}
    public int[] deleteList(List<Sample2Sample2Emp> entityList);
    public int[] deleteListNonstrict(List<Sample2Sample2Emp> entityList);
    public int deleteByQuery(Sample2Sample2EmpCB cb);
}
