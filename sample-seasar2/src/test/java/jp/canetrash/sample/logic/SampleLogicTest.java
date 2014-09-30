package jp.canetrash.sample.logic;


import org.junit.runner.RunWith;
import org.seasar.framework.unit.Seasar2;
import static junit.framework.Assert.*;

@RunWith(Seasar2.class)
public class SampleLogicTest {

    private SampleLogic taget;
    
    /**
     * 足し算のテスト
     */
    public void testPlus() {
        System.out.println(taget.plus(10, 20));
//        assertEquals(3, taget.plus(1, 2));
//        assertEquals(5, taget.plus(2, 3));
//        try {
//            taget.plus(-1, 3);
//            fail();
//        } catch (Exception exepcted) {
//            assertTrue(true);
//        }
    }
}
