// Copyright(c) 2006 ATL Systems, Incorporated.
//
//
package sample.string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class ParseLab {
    
    public void stringTokenizerSample() throws Exception {
        BufferedReader reader = new BufferedReader( new FileReader("src/main/java/sample/string/create-table.sql"));
        StringBuffer sb = new StringBuffer();
        String buf = reader.readLine();
        sb.append(buf);
        while(buf != null) {
            buf = reader.readLine();
            if(buf!= null && buf.indexOf("--") == -1) {
                sb.append(buf);
                sb.append("\n");
            }
        }
        
        StringTokenizer stringTokenizer = new StringTokenizer(sb.toString(), ";");
        while (stringTokenizer.hasMoreElements()) {
            System.out.println("#################");
            String token = stringTokenizer.nextToken();
                System.out.println(token);
            System.out.println("#################");
            
        }
    }

}
