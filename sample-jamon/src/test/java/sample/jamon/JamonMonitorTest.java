// Copyright(c) 2005 Isetan Co.,Ltd. and ATL Systems, Incorporated.
//
//
package sample.jamon;

import junit.framework.TestCase;

public class JamonMonitorTest extends TestCase {

    /*
     * 'sample.jamon.JamonMonitor.monitor()' �̂��߂̃e�X�g�E���\�b�h
     */
    public void testMonitor() {
        JamonMonitor monitor = new JamonMonitor();
        monitor.monitor(100);

    }

}
