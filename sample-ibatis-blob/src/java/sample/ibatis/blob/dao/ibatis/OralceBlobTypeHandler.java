/*
 * Copyright (c) 2005 ATL Systems incorporated.
 * All rights reserved.
 */
package sample.ibatis.blob.dao.ibatis;

import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;

import org.springframework.orm.ibatis.support.BlobByteArrayTypeHandler;

import java.io.ByteArrayInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author funato
 * @createted 2005/08/08
 */
public class OralceBlobTypeHandler extends BlobByteArrayTypeHandler {
    protected void setParameterInternal(PreparedStatement ps, int index, Object value,
        String jdbcType, LobCreator lobCreator) throws SQLException {
        System.out.println("OracleBlobTypeHandler set param");
        if (value == null) {
            return;
        }
        byte[] byteValue = (byte[]) value;
        lobCreator.setBlobAsBinaryStream(ps, index, new ByteArrayInputStream(byteValue), byteValue.length);
    }

    /* (”ñ Javadoc)
     * @see org.springframework.orm.ibatis.support.AbstractLobTypeHandler#getResultInternal(java.sql.ResultSet, int, org.springframework.jdbc.support.lob.LobHandler)
     */
    protected Object getResultInternal(ResultSet rs, int index, LobHandler lobHandler)
        throws SQLException {
        System.out.println("OracleBlobTypeHandler get param");
        return lobHandler.getBlobAsBytes(rs, index);
    }

    /* (”ñ Javadoc)
     * @see com.ibatis.sqlmap.engine.type.TypeHandler#valueOf(java.lang.String)
     */
    public Object valueOf(String s) {
        return s;
    }
}
