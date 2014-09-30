/*
 * Copyright (c) 2005 ATL Systems incorporated.
 * All rights reserved.
 */
package hivemind.sample.impl;

import hivemind.sample.Divider;

/**
 * 
 * @author funato
 * @createted 2005/04/19
 */
public class DividerImpl implements Divider {

    /**
     * @see hivemind.sample.Divider#divide(int, int)
     */
    public int divide(int arg0, int arg1) {
        if(arg1 != 0){
            return arg0 / arg1;
        }
        return 0;
    }

}
