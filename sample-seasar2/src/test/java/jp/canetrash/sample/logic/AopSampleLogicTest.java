package jp.canetrash.sample.logic;


import static org.junit.Assert.*;
import jp.canetrash.sample.test.SampleClass;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.framework.unit.Seasar2;

@RunWith(Seasar2.class)
public class AopSampleLogicTest {

    private SampleClass sampleClass;
    
    @Test
    public void testSimple() {
        assertNotNull(sampleClass);
        sampleClass.sample1();
        sampleClass.sample2();
        sampleClass.sample3();
        sampleClass.sample4();
    }
}
