/*
 * çÏê¨ì˙: 2005/03/29
 */
package jaxor.sample;

import net.sourceforge.jaxor.JaxorContextImpl;
import net.sourceforge.jaxor.QueryParams;

import org.apache.commons.lang.builder.StandardToStringStyle;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 * @author
 */
public class JaxorMain {
    public static void main(String[] args) throws Exception {
        String URL = "jdbc:oracle:thin:@kawasaki:1521:kawasaki";
        String id = "funato_test";
        String pass = "funato_test";
        Class.forName("oracle.jdbc.OracleDriver");

        Connection con = DriverManager.getConnection(URL, id, pass);

        JaxorContextImpl session = new JaxorContextImpl(con);

        EmpFinderBase finder = new EmpFinderBase(session);
        EmpEntity emp = finder.selectByPrimaryKey(new Long(7369), false);
        showDetail(emp);

        EmpList empList = finder.selectByDeptnoList(new Long(30));

        for (EmpIterator itr = empList.iterator(); itr.hasNext();) {
            showDetail(itr.next());
        }

        emp = finder.findUnique("where EMPNO=7876", false);
        showDetail(emp);
        emp = finder.queryUnique("select * from EMP where EMPNO=7782", false);
        showDetail(emp);
        QueryParams params = new QueryParams();
        params.addLong(new Long(7654));
        emp = finder.findUnique("where EMPNO=?", params, false);
        showDetail(emp);
        /*
        emp.delete();
        emp.update();
        */
        session.commit();
        session.end();
    }

    protected static void showDetail(Object obj) {
        StandardToStringStyle style = new StandardToStringStyle();
        style.setFieldSeparator("\n");
        style.setContentStart("[\n");
        style.setContentEnd("\n]");
        System.out.println(ToStringBuilder.reflectionToString(obj, style));
    }
}
