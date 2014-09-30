package jp.co.np.p2netex.sample1.bsdao;

import java.util.List;

import jp.co.np.p2netex.sample1.exentity.Sample1Sample1Dept;
import jp.co.np.p2netex.sample1.cbean.Sample1Sample1DeptCB;

/**
 * The dao interface of SAMPLE1_DEPT.
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public interface Sample1BsSample1DeptDao extends jp.co.np.p2netex.sample1.allcommon.Sample1DaoWritable {

    public Class BEAN = Sample1Sample1Dept.class;// For S2Dao

    public static final String getCountAll_SQL = "select count(*) from SAMPLE1_DEPT";
    public int getCountAll();
    
    public static final String getListAll_SQL = "select ID, NAME, VERSION_NO from SAMPLE1_DEPT";
    public java.util.List<Sample1Sample1Dept> getListAll();
    
    public static final String getEntity_SQL = "select ID, NAME, VERSION_NO from SAMPLE1_DEPT where SAMPLE1_DEPT.ID = /*id*/null";
    public static final String getEntity_ARGS = "id";
    public Sample1Sample1Dept getEntity(java.lang.Integer id);


    public int selectCount(Sample1Sample1DeptCB cb);
    public List<Sample1Sample1Dept> selectList(Sample1Sample1DeptCB cb);

    public int insert(Sample1Sample1Dept entity);
    public int updateModifiedOnly(Sample1Sample1Dept entity);
    public int updateNonstrictModifiedOnly(Sample1Sample1Dept entity);
    public int delete(Sample1Sample1Dept entity);
    public int deleteNonstrict(Sample1Sample1Dept entity);

    public int[] insertList(List<Sample1Sample1Dept> entityList);
    public int[] updateList(List<Sample1Sample1Dept> entityList);
    public int[] updateListNonstrict(List<Sample1Sample1Dept> entityList);
    public int updateByQuery(Sample1Sample1DeptCB cb, Sample1Sample1Dept entity);// {DBFlute-0.7.5}
    public int[] deleteList(List<Sample1Sample1Dept> entityList);
    public int[] deleteListNonstrict(List<Sample1Sample1Dept> entityList);
    public int deleteByQuery(Sample1Sample1DeptCB cb);
}
