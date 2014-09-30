// Copyright(c) 2005 Isetan Co.,Ltd. and ATL Systems, Incorporated.
//
//
package sample.commons.pool;

import junit.framework.TestCase;

/**
 * ƒv[ƒŠƒ“ƒO‚ğŒŸØ‚·‚é
 */
public class PoolingSampleTest extends TestCase {

    public void testSimple() {
        PoolingSample sample = new PoolingSample();
        Object obj = sample.borrowObject();
        System.out.println(obj);
        obj = sample.borrowObject();
        System.out.println(obj);
        obj = sample.borrowObject();
        System.out.println(obj);
        sample.returnObject(obj);
        obj = sample.borrowObject();
        System.out.println(obj);
        sample.returnObject(obj);
        sample.clear();
        sample.close();
    }
}
