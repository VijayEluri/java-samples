// Copyright(c) 2007 ATL Systems, Incorporated.
//
//
package ibatis.test.lab.builder.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.core.io.Resource;
import org.springframework.orm.ibatis.SqlMapClientFactoryBean;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.engine.builder.xml.SqlMapConfigParser;

public class NSqlMapClientFactoryBean extends SqlMapClientFactoryBean {

    protected SqlMapClient buildSqlMapClient(Resource configLocation, Properties properties)
            throws IOException {
        InputStream is = configLocation.getInputStream();
        return new SqlMapConfigParser(null, new SqlMapXmlConverterImpl()).parse(is);
    }

}
