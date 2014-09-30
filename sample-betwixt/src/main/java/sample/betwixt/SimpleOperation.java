/*
 * 作成日: 2005/02/21
 */
package sample.betwixt;

import java.io.File;
import java.io.FileWriter;

import org.apache.commons.betwixt.BindingConfiguration;
import org.apache.commons.betwixt.io.BeanReader;
import org.apache.commons.betwixt.io.BeanWriter;

/**
 * @author funato
 */
public class SimpleOperation {

    /**
     * BeanからXMLへ
     * @param addr Address
     * @param path ファイルのパス
     */
    public void processToXml(Address addr, String path) throws Exception {
        BindingConfiguration config=new BindingConfiguration();
        config.setMapIDs(false);
        
        BeanWriter writer = new BeanWriter(new FileWriter(path));
        writer.setBindingConfiguration(config);
        
        writer.writeXmlDeclaration("<?xml version=\"1.0\" encoding=\"Windows-31j\"?>");

        writer.write(addr);
        writer.close();
    }

    /**
     * XMLからBeanへ
     * @param path XMLファイルのぱす
     * @return Bean
     * @throws Exception
     */
    public Address processToBean(String path) throws Exception {
        BeanReader reader = new BeanReader();
        reader.registerBeanClass(Address.class);
        return (Address)reader.parse(new File(path));
    }

}

