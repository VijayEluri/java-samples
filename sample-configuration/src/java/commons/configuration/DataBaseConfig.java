/*
 * Copyright (c) 2005 ATL Systems incorporated.
 * All rights reserved.
 */
package commons.configuration;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.DatabaseConfiguration;
import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.Statement;


/**
 *
 * @author funato
 * @createted 2005/07/13
 */
public class DataBaseConfig implements Config {
    /**
     * @see commons.configuration.Config#getConfig()
     */
    public Configuration getConfig() {
        Statement stmt = null;
        Connection con = null;

        try {
            BasicDataSource ds = new BasicDataSource();
            ds.setDriverClassName("org.hsqldb.jdbcDriver");
            ds.setUsername("sa");
            ds.setPassword("");
            ds.setUrl("jdbc:hsqldb:mem:prop");
            con = ds.getConnection();
            stmt = con.createStatement();
            stmt.execute(
                "CREATE TABLE PROPS (KEY VARCHAR(10) NOT NULL PRIMARY KEY, VAL VARCHAR(50) NOT NULL)");
            stmt.execute(
                "INSERT INTO PROPS VALUES ('sample.key', 'database sample value')");

            Configuration config = new DatabaseConfiguration(ds, "PROPS",
                    "KEY", "VAL");

            return config;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                }
            }
        }
    }
}
