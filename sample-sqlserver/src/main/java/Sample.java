import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Sample {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn = DriverManager.getConnection(
				"jdbc:sqlserver://192.168.0.195:1433;database=DI", "test",
				"test");
		System.out.println(conn.getCatalog());
		DatabaseMetaData metaData = conn.getMetaData();
		ResultSet tableTypes = metaData.getTableTypes();
		while (tableTypes.next()) {
			System.out.println(tableTypes.getString(1) + ":type");
		}
		
		ResultSet tables = metaData.getTables("MX", "scm1", null, null);
		while (tables.next()) {
			System.out.print(tables.getString(1) + " " + tables.getString(2) +" " +tables.getString(3));
			System.out.println();
		}

		/*
		// ステートメントを作成
		Statement stmt = conn.createStatement();

		// 問合せの実行
		ResultSet rset = stmt.executeQuery("select EMPNO, ENAME from EMP");

		// 問合せ結果の表示
		while (rset.next()) {
			// 列番号による指定
			System.out.println(rset.getInt(1) + "\t" + rset.getString(2));
		}

		// 結果セットをクローズ
		rset.close();

		// ステートメントをクローズ
		stmt.close();

		// 接続をクローズ
		 */
		conn.close();
	}
}
