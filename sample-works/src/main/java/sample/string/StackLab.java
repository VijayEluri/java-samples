// Copyright(c) 2006 ATL Systems, Incorporated.
//
//
package sample.string;

import java.util.Stack;

public class StackLab {

    public void stack() {
       Stack<String> stack
        = new Stack<String>();
       stack.push("1");
       stack.push("2");
       stack.push("3");
       System.out.println("peak:" + stack.peek());
       StringBuffer sb = new StringBuffer();
       while (!stack.isEmpty()) {
           sb.append(stack.pop());
           if (!stack.isEmpty()) {
               sb.append(">");
           }
       }
       System.out.println(sb.toString());
    }
    
}
