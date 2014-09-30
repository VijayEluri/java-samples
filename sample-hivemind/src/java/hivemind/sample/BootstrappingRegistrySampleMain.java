/*
 * Copyright (c) 2005 ATL Systems incorporated.
 * All rights reserved.
 */
package hivemind.sample;

import org.apache.hivemind.Registry;
import org.apache.hivemind.impl.RegistryBuilder;

/**
 * 
 * @author funato
 * @createted 2005/04/19
 */
public class BootstrappingRegistrySampleMain {

    public static void main(String[] args) {
        int arg0 = 5;
        int arg1 = 5;

        Registry registry = RegistryBuilder.constructDefaultRegistry();

        //List list = registry.getConfiguration("hivemind.sample");
        Calculator c =
          (Calculator) registry.getService(Calculator.class);

        System.out.println("Inputs " + arg0 + " and " + arg1);

        System.out.println("Add   : " + c.add(arg0, arg1));
        System.out.println("Subtract: " + c.subtract(arg0, arg1));
        System.out.println("Multiply: " + c.multiply(arg0, arg1));
        System.out.println("Divide  : " + c.divide(arg0, arg1));
    }
}
