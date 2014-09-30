/*
 * Copyright (c) 2005 ATL Systems incorporated.
 * All rights reserved.
 */
package hivemind.sample.impl;

import hivemind.sample.Subtracter;

/**
 * 
 * @author funato
 * @createted 2005/04/19
 */
public class SubtracterImpl implements Subtracter {

    /**
     * @see hivemind.sample.Subtracter#subtract(int, int)
     */
    public int subtract(int arg0, int arg1) {
        return arg0 - arg1;
    }

}
