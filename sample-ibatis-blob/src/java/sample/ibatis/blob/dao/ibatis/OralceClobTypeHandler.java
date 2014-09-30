/*
 * Copyright (c) 2005 ATL Systems incorporated.
 * All rights reserved.
 */
package sample.ibatis.blob.dao.ibatis;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.orm.ibatis.support.BlobByteArrayTypeHandler;


/**
 *
 * @author funato
 * @createted 2005/08/08
 */
public class OralceClobTypeHandler extends BlobByteArrayTypeHandler {
    protected void setParameterInternal(PreparedStatement ps, int index, Object value,
        String jdbcType, LobCreator lobCreator) throws SQLException {
        System.out.println("OracleClobTypeHandler");
        if (value == null) { 
            return; 
        } 
        String buf = null; 
        Writer writer = new StringWriter(); 
            buf =  new String ((char[])value);
        if (buf != null) { 
            int size = buf.length(); 
            Reader reader = new BufferedReader(new StringReader(buf)); 
            try { 
                lobCreator.setClobAsCharacterStream(ps, index, reader, size); 
            } 
            finally { 
                try{
                reader.close(); 
                } catch(Exception e){}
            } 
        } 
    }

    /* (”ñ Javadoc)
     * @see org.springframework.orm.ibatis.support.AbstractLobTypeHandler#getResultInternal(java.sql.ResultSet, int, org.springframework.jdbc.support.lob.LobHandler)
     */
    protected Object getResultInternal(ResultSet rs, int index, LobHandler lobHandler)
        throws SQLException {
        String str = lobHandler.getClobAsString(rs, index);
        if(str != null){
            return str.toCharArray();
        } else {
            return null;
        }
    }

    /* (”ñ Javadoc)
     * @see com.ibatis.sqlmap.engine.type.TypeHandler#valueOf(java.lang.String)
     */
    public Object valueOf(String s) {
        return s;
    }
}
