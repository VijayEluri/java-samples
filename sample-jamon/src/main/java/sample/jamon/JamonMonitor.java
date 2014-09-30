// Copyright(c) 2005 Isetan Co.,Ltd. and ATL Systems, Incorporated.
//
//
package sample.jamon;

import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;


public class JamonMonitor {

    public void monitor(int count) {
        Monitor mon = null;
        LoadClass load = new LoadClass();

        for (int i = 0; i <= count; i++) {
            // MonitorFactory����Start���Ăяo��
            mon = MonitorFactory.start("myFirstMonitor");
            load.load();
            // Monitor����Stop���Ăяo��
            mon.stop();
        }

        System.out.println(mon); // toString() method called
    }
}
