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
             * sql-map-config.xml��lazyLoadingEnabled��
             * true,false�ɕύX���Ď��s����ƁA���O�̏o�͂��ς��.
             * lazyLoadingEnabled���L�����ƁAdpt.getName()���Ă΂�邽�т�
             * SQL�����s����邪�A�������ƁA�ŏ���Employee�̃��X�g���擾����
             * �Ƃ��ɁA���ׂĂ�Department���擾����.
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
