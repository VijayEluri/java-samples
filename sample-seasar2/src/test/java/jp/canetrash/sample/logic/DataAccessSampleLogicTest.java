package jp.canetrash.sample.logic;

import static junit.framework.Assert.assertEquals;

import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import jp.canetrash.sample.dto.EmpDto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.extension.dataset.DataSet;
import org.seasar.extension.dataset.DataTable;
import org.seasar.framework.unit.DataAccessor;
import org.seasar.framework.unit.Seasar2;
import org.seasar.framework.unit.TestContext;
import org.seasar.framework.unit.annotation.Mock;
import org.seasar.framework.unit.annotation.PostBindFields;
import org.seasar.framework.unit.annotation.PreUnbindFields;
import org.seasar.framework.util.StatementUtil;

@RunWith(Seasar2.class)
public class DataAccessSampleLogicTest {

    private DataAccessSampleLogic target;

    private DataAccessor dataAccessor;

    private TestContext testContext;

    private DataSource ds;
    
    @PostBindFields
    public void postBindFields() throws Exception {
        Statement statement = ds.getConnection().createStatement();
        StatementUtil
                .execute(statement,
                        "CREATE TABLE emp ( id BIGINT NOT NULL, name  VARCHAR2 (100) )");
        StatementUtil.close(statement);
        
    }

    @PreUnbindFields
    public void preUnbindFields() throws Exception {
        Statement statement = ds.getConnection().createStatement();
        StatementUtil.execute(statement, "DROP TABLE emp");
        StatementUtil.close(statement);
    }

    @Mock(target = SampleLogic.class, pointcut = "plus", returnValue = "new Integer(10)")
    @Test
    public void testInsertData() throws Exception {
        target.insertData();
        DataTable actual = dataAccessor.readDbByTable("emp");
        DataSet expected = testContext.getExpected();
        assertEquals(expected.getTable("emp"), actual);
    }

    @Test
    public void testGetEmpAllRecord() throws Exception {
        List<EmpDto> actual = target.getEmpAllRecord();
        assertEquals(10, actual.size());
    }
}
