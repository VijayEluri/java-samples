
package jaxor.sample;

import java.util.List;
import java.sql.*;
import net.sourceforge.jaxor.*;
import net.sourceforge.jaxor.util.*;


public class EmpBase extends net.sourceforge.jaxor.AbstractEntity implements EmpEntity{

	private EmpEntityRow _row = new EmpEntityRow();

	public String getEname() {
		return ( String ) _row.ename.getValue();
	}
	public void setEname(String arg){
		_row.ename.setValue(arg);
	}
	public String getJob() {
		return ( String ) _row.job.getValue();
	}
	public void setJob(String arg){
		_row.job.setValue(arg);
	}
	public Long getMgr() {
		return ( Long ) _row.mgr.getValue();
	}
	public void setMgr(Long arg){
		_row.mgr.setValue(arg);
	}
	public java.sql.Date getHiredate() {
		return ( java.sql.Date ) _row.hiredate.getValue();
	}
	public void setHiredate(java.sql.Date arg){
		_row.hiredate.setValue(arg);
	}
	public Long getSal() {
		return ( Long ) _row.sal.getValue();
	}
	public void setSal(Long arg){
		_row.sal.setValue(arg);
	}
	public Long getComm() {
		return ( Long ) _row.comm.getValue();
	}
	public void setComm(Long arg){
		_row.comm.setValue(arg);
	}
	public Long getDeptno() {
		return ( Long ) _row.deptno.getValue();
	}
	public void setDeptno(Long arg){
		_row.deptno.setValue(arg);
	}
	public Long getEmpno() {
		return ( Long ) _row.empno.getValue();
	}
	public void setEmpno(Long arg){
		_row.empno.setValue(arg);
	}
    
    





    public EmpBase() {}

        public EmpBase ( final Long empno ){
        init(empno);
    }

    public void init ( final Long empno ){
                   this._row.empno.setValue( empno );
           }


    public EntityRow getFields(){
		return _row;
    }

    public void setFields(EntityRow row){
        _row = ( EmpEntityRow ) row;
    }
}
