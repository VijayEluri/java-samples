
package jaxor.sample;

import net.sourceforge.jaxor.*;


public class EmpMetaRow extends net.sourceforge.jaxor.MetaRow{

    	private MetaField ENAME_META = new MetaField("ename",
                          "Ename", true,false,false,false , net.sourceforge.jaxor.mappers.StringMapper.class);
    	private MetaField JOB_META = new MetaField("job",
                          "Job", true,false,false,false , net.sourceforge.jaxor.mappers.StringMapper.class);
    	private MetaField MGR_META = new MetaField("mgr",
                          "Mgr", true,false,false,false , net.sourceforge.jaxor.mappers.LongMapper.class);
    	private MetaField HIREDATE_META = new MetaField("hiredate",
                          "Hiredate", true,false,false,false , net.sourceforge.jaxor.mappers.DateMapper.class);
    	private MetaField SAL_META = new MetaField("sal",
                          "Sal", true,false,false,false , net.sourceforge.jaxor.mappers.LongMapper.class);
    	private MetaField COMM_META = new MetaField("comm",
                          "Comm", true,false,false,false , net.sourceforge.jaxor.mappers.LongMapper.class);
    	private MetaField DEPTNO_META = new MetaField("deptno",
                          "Deptno", true,false,false,false , net.sourceforge.jaxor.mappers.LongMapper.class);
    	private MetaField EMPNO_META = new MetaField("empno",
                          "Empno", false,true,true,false , net.sourceforge.jaxor.mappers.LongMapper.class);
    
    
	public EmpMetaRow (){
		super("Emp", EmpBase.class, EmpList.class);
		            add(ENAME_META);
		            add(JOB_META);
		            add(MGR_META);
		            add(HIREDATE_META);
		            add(SAL_META);
		            add(COMM_META);
		            add(DEPTNO_META);
		            add(EMPNO_META);
			}

	
	public MetaField getEname(){
	    return ENAME_META;
	}

    public void setEname(MetaField field){
	     ENAME_META = field;
	}
    
	public MetaField getJob(){
	    return JOB_META;
	}

    public void setJob(MetaField field){
	     JOB_META = field;
	}
    
	public MetaField getMgr(){
	    return MGR_META;
	}

    public void setMgr(MetaField field){
	     MGR_META = field;
	}
    
	public MetaField getHiredate(){
	    return HIREDATE_META;
	}

    public void setHiredate(MetaField field){
	     HIREDATE_META = field;
	}
    
	public MetaField getSal(){
	    return SAL_META;
	}

    public void setSal(MetaField field){
	     SAL_META = field;
	}
    
	public MetaField getComm(){
	    return COMM_META;
	}

    public void setComm(MetaField field){
	     COMM_META = field;
	}
    
	public MetaField getDeptno(){
	    return DEPTNO_META;
	}

    public void setDeptno(MetaField field){
	     DEPTNO_META = field;
	}
    
	public MetaField getEmpno(){
	    return EMPNO_META;
	}

    public void setEmpno(MetaField field){
	     EMPNO_META = field;
	}
    
    

}
