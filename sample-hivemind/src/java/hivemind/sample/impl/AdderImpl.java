/*
 * Copyright (c) 2005 ATL Systems incorporated.
 * All rights reserved.
 */
package hivemind.sample.impl;

import hivemind.sample.Adder;


/**
 *
 * @author funato
 * @createted 2005/04/19
 */
public class AdderImpl implements Adder {
    /**
     * @see hivemind.sample.Adder#add(int, int)
     */
    public int add(int arg0, int arg1) {
        return arg0 + arg1;
    }
}
