package jp.canetrash.sample.s2jdbc;

import jp.canetrash.sample.s2jdbc.entity.Employee;
import junit.framework.TestCase;

import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.factory.S2ContainerFactory;

public class S2JDBCTest extends TestCase {
    public void testSimple() throws Exception {
        S2Container container = S2ContainerFactory.create("s2jdbc.dicon");
        container.init();
        JdbcManager jdbcManager = (JdbcManager) container.getComponent("jdbcManager");
        Employee result = jdbcManager.from(Employee.class).getSingleResult();
    }
}
