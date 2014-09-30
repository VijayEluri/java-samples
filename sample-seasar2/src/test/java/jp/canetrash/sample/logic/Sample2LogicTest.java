package jp.canetrash.sample.logic;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.seasar.framework.unit.Seasar2;

@RunWith(Seasar2.class)
public class Sample2LogicTest {

    private Sample2Logic sample2Logic;

    public void testSimple() {
        assertNotNull(sample2Logic);
        sample2Logic.transactionTest();
    }
}
