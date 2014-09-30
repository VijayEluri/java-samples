// Copyright(c) 2007 ATL Systems, Incorporated.
//
//
package ibatis.test.dao.impl;

import ibatis.test.bean.Guitar;
import ibatis.test.dao.GuitarDao;

import java.util.List;
import java.util.UUID;

import junit.framework.TestCase;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class GuitarDaoImplTest extends TestCase {
    public void testFindById() {
        FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext(new String[]{"classpath:applicationContext.xml"}); 
         GuitarDao guitarDao = (GuitarDao) ctx.getBean("guitarDao");
         List<Guitar> result = guitarDao.findById("1");
    }
    
    public void testInsert() {
        FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext(new String[]{"classpath:applicationContext.xml"}); 
        GuitarDao guitarDao = (GuitarDao) ctx.getBean("guitarDao");
        Guitar guitar = new Guitar();
        guitar.setId(Long.toString(System.currentTimeMillis()));
        guitar.setMaker("hoge");
        guitar.setName("guhya");
        guitarDao.insert(guitar);
    }
    
    public void testCreateTable() {
        FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext(new String[]{"classpath:applicationContext.xml"}); 
         GuitarDao guitarDao = (GuitarDao) ctx.getBean("guitarDao");
         guitarDao.createTable();
    }

}
