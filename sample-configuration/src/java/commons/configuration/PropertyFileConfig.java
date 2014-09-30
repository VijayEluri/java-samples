/*
 * Copyright (c) 2005 ATL Systems incorporated.
 * All rights reserved.
 */
package commons.configuration;

import java.net.URL;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;


/**
 *
 * @author funato
 * @createted 2005/07/13
 */
public class PropertyFileConfig implements Config {
    /**
     * @see commons.configuration.Config#getConfig()
     */
    public Configuration getConfig() {
        Configuration config = null;

        try {
            URL url = this.getClass().getResource("sample.properties");
            config = new PropertiesConfiguration(url.getFile());
        } catch (ConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return config;
    }
}
