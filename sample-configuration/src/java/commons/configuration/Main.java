/*
 * Copyright (c) 2005 ATL Systems incorporated.
 * All rights reserved.
 */
package commons.configuration;

import org.apache.commons.configuration.Configuration;

/**
 * 
 * @author funato
 * @createted 2005/07/13
 */
public class Main {

    public static void main(String[] args) {
        execPropFileConfig();
        execDatabaseConfig();
    }
    
    /**
     * プロパティファイル
     * 
     */
    public static void execPropFileConfig(){
        Configuration config = ConfigFactory.getPropertyConfig();
        System.out.println(config.getString("sample.property"));
        System.out.println(config.getString("application.title"));
        String[] array1 = config.getStringArray("array1.property");
        for(int i=0;i<array1.length;i++){
            System.out.println(array1[i]);
        }
        String[] array2 = config.getStringArray("array2.property");
        for(int i=0;i<array2.length;i++){
            System.out.println(array2[i]);
        }
        
    }
    /**
     * データベース
     * 
     */
    public static void execDatabaseConfig(){
        Configuration config = ConfigFactory.getDataBaseConfig();
        System.out.println(config.getString("sample.key"));
    }
}
