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
public class ConfigFactory {
    /**
     * プロパティファイルから設定を取得する
     * @return
     */
    public static Configuration getPropertyConfig() {
        Config config = new PropertyFileConfig();

        return config.getConfig();
    }
    
    /**
     * DataBaseから設定を取得する.
     * @return
     */
    public static Configuration getDataBaseConfig(){
        Config config = new DataBaseConfig();
        return config.getConfig();
    }
}
