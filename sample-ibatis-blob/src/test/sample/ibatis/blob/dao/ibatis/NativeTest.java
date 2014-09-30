/*
 * Copyright (c) 2005 ATL Systems incorporated.
 * All rights reserved.
 */
package sample.ibatis.blob.dao.ibatis;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author funato
 * @createted 2005/08/08
 */
public class NativeTest extends TestCase {
    private static ApplicationContext context;
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        super.setUp();
    }
    public void testSimple() throws Exception {
       DataSource ds = (DataSource)context.getBean("dataSource"); 
       Connection con = ds.getConnection();
       File file = new File("src/conf/sample.jpg");
       System.out.println(file.length());
       String sql = "insert into REPORT(id, data) VALUES('9', ?)";
       PreparedStatement stmt = con.prepareStatement(sql);
       InputStream is =  new FileInputStream(file);
       stmt.setBinaryStream(1, is, (int)file.length());
       int result = stmt.executeUpdate();
       is.close();

       stmt.close();
       con.close();
    }
    public void testSimple2() throws Exception {
       DataSource ds = (DataSource)context.getBean("dataSource"); 
       Connection con = ds.getConnection();
        Statement state = con.createStatement();
        String sql = "select * from report";
        boolean result = state.execute(sql);
        ResultSet rs = state.getResultSet();
        while(rs.next()) {
            String id = rs.getString(1);
            Blob blob = rs.getBlob(4);
            InputStream in = blob.getBinaryStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int bytes;
            byte b[] = new byte[4096];
            while ((bytes = in.read(b)) != -1){
                baos.write(b, 0, bytes);
            }
            System.out.println(id + ":" + baos.toString());
        }
        con.close();
    }
}
