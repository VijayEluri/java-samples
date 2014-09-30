package jp.co.np.p2netex.sample2.bsdao;

import java.util.List;

import jp.co.np.p2netex.sample2.exentity.Sample2Sample2Dept;
import jp.co.np.p2netex.sample2.cbean.Sample2Sample2DeptCB;

/**
 * The dao interface of SAMPLE2_DEPT.
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public interface Sample2BsSample2DeptDao extends jp.co.np.p2netex.sample2.allcommon.Sample2DaoWritable {

    public Class BEAN = Sample2Sample2Dept.class;// For S2Dao

    public static final String getCountAll_SQL = "select count(*) from SAMPLE2_DEPT";
    public int getCountAll();
    
    public static final String getListAll_SQL = "select ID, NAME, VERSION_NO from SAMPLE2_DEPT";
    public java.util.List<Sample2Sample2Dept> getListAll();
    
    public static final String getEntity_SQL = "select ID, NAME, VERSION_NO from SAMPLE2_DEPT where SAMPLE2_DEPT.ID = /*id*/null";
    public static final String getEntity_ARGS = "id";
    public Sample2Sample2Dept getEntity(java.lang.Integer id);


    public int selectCount(Sample2Sample2DeptCB cb);
    public List<Sample2Sample2Dept> selectList(Sample2Sample2DeptCB cb);

    public int insert(Sample2Sample2Dept entity);
    public int updateModifiedOnly(Sample2Sample2Dept entity);
    public int updateNonstrictModifiedOnly(Sample2Sample2Dept entity);
    public int delete(Sample2Sample2Dept entity);
    public int deleteNonstrict(Sample2Sample2Dept entity);

    public int[] insertList(List<Sample2Sample2Dept> entityList);
    public int[] updateList(List<Sample2Sample2Dept> entityList);
    public int[] updateListNonstrict(List<Sample2Sample2Dept> entityList);
    public int updateByQuery(Sample2Sample2DeptCB cb, Sample2Sample2Dept entity);// {DBFlute-0.7.5}
    public int[] deleteList(List<Sample2Sample2Dept> entityList);
    public int[] deleteListNonstrict(List<Sample2Sample2Dept> entityList);
    public int deleteByQuery(Sample2Sample2DeptCB cb);
}
