// Copyright(c) 2005 Isetan Co.,Ltd. and ATL Systems, Incorporated.
//
//
package sample.jamon;

import java.security.SecureRandom;


public class LoadClass {
    public void load() {
        SecureRandom.getSeed(128);
    }
}
