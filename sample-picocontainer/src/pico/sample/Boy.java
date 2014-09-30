/*
 * Copyright (c) 2005 ATL Systems incorporated.
 * All rights reserved.
 */
package pico.sample;

/**
 * 
 * @author funato
 * @createted 2005/04/14
 */
public class Boy implements Kissable{
    public void kiss(Object kisser) {
        System.out.println("I was kissed by " + kisser);
    }
}
