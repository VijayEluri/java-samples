package jp.co.np.p2netex.sample;

import static org.junit.Assert.assertEquals;
import jp.co.np.p2netex.sample1.cbean.Sample1Sample1EmpCB;
import jp.co.np.p2netex.sample1.exbhv.Sample1Sample1EmpBhv;
import jp.co.np.p2netex.sample2.cbean.Sample2Sample2EmpCB;
import jp.co.np.p2netex.sample2.exbhv.Sample2Sample2EmpBhv;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.framework.unit.Seasar2;


@RunWith(Seasar2.class)
public class MultipleDBTest {

    
    /**
     * Injection Component
     */
    private Sample1Sample1EmpBhv sample1Sample1EmpBhv;
    
    /**
     * Injection Component
     */
    private Sample2Sample2EmpBhv sample2Sample2EmpBhv;
    
    /**
     * サンプル１のDBからレコードをとってきてサンプル２のDBから同じレコードがないことを確認
     * それぞれのデータ:
     * dbflute_sample1/playsql/replace-schema.sql
     * dbflute_sample2/playsql/replace-schema.sql
     * 注意点はdbflute-sample1.diconとdbflute-sample2.diconでの
     * interceptorの設定がdbfluteが生成したものだとコンポーネントが見つからないといわれるので注意
     * @throws Exception
     */
    @Test
    public void selectList_Tx() throws Exception {
        // Sample1の検索
        Sample1Sample1EmpCB cb1 = new Sample1Sample1EmpCB();
        cb1.query().setName_Equal("SMITH");
        int count1 = sample1Sample1EmpBhv.selectCount(cb1);
        assertEquals(1, count1);

        // Sample2の検索
        Sample2Sample2EmpCB cb2 = new Sample2Sample2EmpCB();
        cb2.query().setName_Equal("SMITH");
        int count2 = sample2Sample2EmpBhv.selectCount(cb2);
        assertEquals(0, count2);
    }
}
