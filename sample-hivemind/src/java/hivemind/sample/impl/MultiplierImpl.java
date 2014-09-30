/*
 * Copyright (c) 2005 ATL Systems incorporated.
 * All rights reserved.
 */
package hivemind.sample.impl;

import hivemind.sample.Multiplier;

/**
 * 
 * @author funato
 * @createted 2005/04/19
 */
public class MultiplierImpl implements Multiplier {

    /**
     * @see hivemind.sample.Multiplier#multiply(int, int)
     */
    public int multiply(int arg0, int arg1) {
        return arg0 * arg1;
    }

}
