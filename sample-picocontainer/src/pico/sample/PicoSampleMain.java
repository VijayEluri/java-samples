/*
 * Copyright (c) 2005 ATL Systems incorporated.
 * All rights reserved.
 */
package pico.sample;

import org.picocontainer.MutablePicoContainer;
import org.picocontainer.defaults.DefaultPicoContainer;

/**
 * 
 * @author funato
 * @createted 2005/04/14
 */
public class PicoSampleMain {

    public static void main(String[] args) {
        MutablePicoContainer pico = new DefaultPicoContainer();
        pico.registerComponentImplementation(Boy.class);
        pico.registerComponentImplementation(Girl.class);
        pico.start();
    }
}
