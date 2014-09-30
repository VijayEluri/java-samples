/*
 * ì¬“ú: 2005/03/29
 */
package ibatis.domain;

import junit.framework.TestCase;

/**
 * @author
 */
public class DepartmentTest extends TestCase {
    public void testSimple() throws Exception {
        Department dpt = new Department();
        dpt.setCd("100");
        dpt.setName("Department");
        
        assertEquals("100", dpt.getCd());
        assertEquals("Department", dpt.getName());
    }
}
