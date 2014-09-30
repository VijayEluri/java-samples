/*
 * çÏê¨ì˙: 2005/03/29
 */
package ibatis.domain;

import junit.framework.TestCase;

/**
 * @author
 */
public class EmployeeTest extends TestCase {
    public void testSimple() throws Exception {
        Employee emp = new Employee();
        Department dpt = new Department();
        
        emp.setDpt(dpt);
        emp.setDptCd("100");
        emp.setId(50);
        emp.setName("Test");
        
        assertEquals(dpt.hashCode(), emp.getDpt().hashCode());
        assertEquals("100", emp.getDptCd());
        assertEquals(50, emp.getId());
        assertEquals("Test", emp.getName());
        
    }
}
