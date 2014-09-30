package sample.freemarker;

import sample.freemarker.FreeMarkerSimpleSample;
import junit.framework.TestCase;

public class FreeMarkerSimpleSampleTest extends TestCase {

    /*
     * 'sample.freemaker.FreeMarkerSimpleSample.process()' のためのテスト・メソッド
     */
    public void testProcess() {
        FreeMarkerSimpleSample target = new FreeMarkerSimpleSample();
        target.process();
    }
}
