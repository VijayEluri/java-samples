package jp.canetrash.sample.logic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import jp.canetrash.sample.dto.EmpDto;

public class DataAccessSampleLogic {

    public DataSource ds;

    public SampleLogic sampleLogic;
   
    public List<EmpDto> getEmpAllRecord() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM EMP");
            List<EmpDto> list = new ArrayList<EmpDto>();
            while (rs.next()) {
                EmpDto dto = new EmpDto();
                dto.id = rs.getInt(1);
                dto.name = rs.getString(2);
                list.add(dto);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

    }

    public void insertData() {
        Connection con = null;
        Statement stmt = null;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            int count = sampleLogic.plus(1, 5);
            for (int i = 0; i < count; i++) {
                stmt.executeUpdate("INSERT INTO EMP (id, name) values (" + i + ", 'test')");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

    }
}
