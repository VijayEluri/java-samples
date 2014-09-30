package jp.canetrash.sample.postgresql;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.io.IOUtils;

public class DatabaseAccess {

	private static final int COUNT = 600000;

	public void dbSelect() throws Exception {
		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql://localhost:5432/np";
		Connection con = DriverManager.getConnection(url, "np", "npnpnp");

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(getPlainSQL());
//		PreparedStatement stmt = con.prepareStatement(getSql());
//		Long[] val = getValue();
//		for (int i = 0; i < COUNT; i++) {
//			stmt.setLong(i + 1, val[i]);
//		}
//		ResultSet rs = stmt.executeQuery();
//
		rs.close();
		stmt.close();
		con.close();
	}

	private String getSql() throws Exception {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < COUNT; i++) {
			sb.append("?,");
		}
		String substring = sb.substring(0, sb.length() - 1);
		String sql = "SELECT taskid, MAX(ViewId) as viewId\n"
				+ "FROM CdoTaskAssign\n" + "WHERE taskId IN (" + substring 
				+ ")\n" + "AND ViewId <= 1000000000000000000\n"
				+ "GROUP BY taskid";
	    IOUtils.write(sql, new FileOutputStream("prepared.txt"));	
		return sql;
	}
	
	private Long[] getValue() {
		Long[] values = new Long[COUNT];
		for (int i = 0; i < COUNT; i++) {
			values[i] = new Long(i);
		}
		return values;
	}
	
	private String getPlainSQL() throws Exception {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < COUNT; i++) {
			sb.append(i);
			sb.append(",");
		}
		String substring = sb.substring(0, sb.length() - 1);
		String sql = "SELECT taskid, MAX(ViewId) as viewId\n"
				+ "FROM CdoTaskAssign\n" + "WHERE taskId IN (" + substring 
				+ ")\n" + "AND ViewId <= 1000000000000000000\n"
				+ "GROUP BY taskid";
	    IOUtils.write(sql, new FileOutputStream("plain.txt"));	
		return sql;
		
	}
}
