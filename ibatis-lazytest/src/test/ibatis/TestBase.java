package ibatis;

import com.ibatis.common.jdbc.ScriptRunner;

import com.ibatis.common.resources.Resources;

import ibatis.service.EmployeeService;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;

import javax.sql.DataSource;


public class TestBase extends TestCase {
    private static final String INSERT_DATA_SQL = "insert-data.sql";
    private static final String CREATE_TABLE_SQL = "create-table.sql";
    private static final ApplicationContext context =
        new ClassPathXmlApplicationContext("applicationContext.xml");

    /*
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception {
        craeteTables();
        insertData();
        super.setUp();
    }

    /*
     * @see TestCase#tearDown()
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Constructor for TestBase.
     * @param arg0
     */
    public TestBase(String arg0) throws Exception {
        super(arg0);
    }

    protected EmployeeService getEmployeeService() {
        return (EmployeeService)context.getBean("empService");
    }

    private void craeteTables() throws Exception {
        execSql(CREATE_TABLE_SQL);
    }

    private void insertData() throws Exception {
        execSql(INSERT_DATA_SQL);
    }

    private void execSql(String resourcePath) throws Exception {
        Connection conn =
            ((DataSource)context.getBean("dataSource")).getConnection();
        ScriptRunner runner = new ScriptRunner();
        runner.runScript(conn, Resources.getResourceAsReader(resourcePath));
        conn.close();
    }
}
