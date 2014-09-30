// Copyright(c) 2005 ATL Systems, Incorporated.
//
//
package sample.rhino;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

/**
 * Rhino（Java上でのJavascriptの実行環境）のテスト
 * @version $Revision$
 * @author $Author$
 * @date $Date$
 * @url $HeadURL$
 * @id $Id$
 */
public class SampleRhinoMain {
    

    /**
     * @param args
     */
    public static void main(String[] str) {
        String[] args = new String[1];
        args[0] = "new Date();";
        
        // Creates and enters a Context. The Context stores information
        // about the execution environment of a script.
        Context cx = Context.enter();
        try {
            // Initialize the standard objects (Object, Function, etc.)
            // This must be done before scripts can be executed. Returns
            // a scope object that we use in later calls.
            Scriptable scope = cx.initStandardObjects();

            // Collect the arguments into a single string.
            String s = "";
            for (int i=0; i < args.length; i++) {
                s += args[i];
            }

            // Now evaluate the string we've colected.
            Object result = cx.evaluateString(scope, s, "<cmd>", 1, null);

            // Convert the result to a string and print it.
            System.err.println(cx.toString(result));

        } finally {
            // Exit from the context.
            Context.exit();
        }
    }

}
