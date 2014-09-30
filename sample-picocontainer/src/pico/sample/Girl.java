/*
 * Copyright (c) 2005 ATL Systems incorporated.
 * All rights reserved.
 */
package pico.sample;

import org.picocontainer.Startable;

/**
 * 
 * @author funato
 * @createted 2005/04/14
 */
public class Girl implements Startable {
    Kissable kissable;

    public Girl(Kissable kissable) {
        this.kissable = kissable;
    }

    public void start() {
        kissable.kiss(this);
    }

    public void stop() {
    }
}
