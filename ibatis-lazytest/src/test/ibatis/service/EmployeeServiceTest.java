package ibatis.service;

import ibatis.TestBase;
import ibatis.domain.Department;
import ibatis.domain.Employee;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class EmployeeServiceTest extends TestBase {
    Log log = LogFactory.getLog(EmployeeServiceTest.class);

    public EmployeeServiceTest(String name) throws Exception {
        super(name);
    }
   public void testGetEmpList() throws Exception {
        EmployeeService service = getEmployeeService();
        List list  = service.getEmpList();
        for(Iterator itr=list.iterator();itr.hasNext();){
            Employee emp = (Employee)itr.next();
            Department dpt = emp.getDpt();
            /*
             * sql-map-config.xmlのlazyLoadingEnabledを
             * true,falseに変更して実行すると、ログの出力が変わる.
             * lazyLoadingEnabledが有効だと、dpt.getName()が呼ばれるたびに
             * SQLが発行されるが、無効だと、最初のEmployeeのリストを取得する
             * ときに、すべてにDepartmentを取得する.
             */
            log.debug("######" + dpt.getName());
        }
        
        
   }
   public void testSetEmpDao() throws Exception {
       assertEquals(true, true);
   }
   
   public void testGetEmpByPk() throws Exception {
       EmployeeService service = getEmployeeService();
       Employee emp = service.getEmpByPk("1");
       assertEquals("John", emp.getName());
   }
}
