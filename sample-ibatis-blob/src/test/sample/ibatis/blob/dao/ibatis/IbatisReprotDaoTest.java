/*
 * Copyright (c) 2005 ATL Systems incorporated.
 * All rights reserved.
 */
package sample.ibatis.blob.dao.ibatis;

import java.io.FileInputStream;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample.ibatis.blob.dao.ReportDao;
import sample.ibatis.blob.domain.Report;


/**
 *
 * @author funato
 * @createted 2005/08/08
 */
public class IbatisReprotDaoTest extends TestCase {
    private static ApplicationContext context;

    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        super.setUp();
    }

    public void testBlob() throws Exception {
        ReportDao dao = (ReportDao)context.getBean("reportDao");
        // Insert
        Report report = new Report();
        report.setId("99999");
        report.setName("name");
        report.setDescription("内容説明");
        FileInputStream fis = new FileInputStream("src/conf/sample.jpg");
        byte[] imgByte = new byte[fis.available()];
        int rec;
        for(int i=0;(rec=fis.read())!= -1;i++){
            imgByte[i] = (byte)rec;
        }
        report.setData(imgByte);
        dao.insert(report);
        
        // Select
        assertNotNull(dao);
        report = dao.findByPk("99999");
        assertEquals("name", report.getName());
        assertEquals("内容説明", report.getDescription());
        assertEquals(15413, report.getData().length);
        
        // Update
        report.setName("change name");
        report.setDescription("変更内容説明");
        fis = new FileInputStream("src/conf/changeimage.jpg");
        imgByte = new byte[fis.available()];
        for(int i=0;(rec=fis.read())!= -1;i++){
            imgByte[i] = (byte)rec;
        }
        report.setData(imgByte);
        dao.update(report);
        
        // Delete
        dao.delete("99999");
    }

    public void testClob() throws Exception {
        // Insert
        ReportDao dao = (ReportDao)context.getBean("reportDao");
        Report report = new Report();
        report.setId("00000");
        report.setName("name");
        report.setDescription("内容説明");
        FileInputStream fis = new FileInputStream("src/conf/sample.txt");
        char[] charArray = new char[fis.available()];
        int rec;
        for(int i=0;(rec=fis.read())!= -1;i++){
            charArray[i] = (char)rec;
        }
        report.setCharData(charArray);
        dao.insert2(report);
        
        // Select
        assertNotNull(dao);
        report = dao.findByPk2("00000");
        assertEquals("name", report.getName());
        assertEquals("内容説明", report.getDescription());
        assertEquals(842, report.getCharData().length);
        
        // Update
        report.setName("change name");
        report.setDescription("変更内容説明");
        fis = new FileInputStream("src/conf/changesample.txt");
        charArray = new char[fis.available()];
        for(int i=0;(rec=fis.read())!= -1;i++){
            charArray[i] = (char)rec;
        }
        report.setCharData(charArray);
        dao.update2(report);
        report = dao.findByPk2("00000");
        assertEquals(428, report.getCharData().length);
        
        // Delete
        dao.delete2("00000");
        
    }
}
