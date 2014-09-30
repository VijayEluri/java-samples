
package jaxor.sample;

import net.sourceforge.jaxor.*;
import net.sourceforge.jaxor.api.*;


public class EmpFinderBase implements FinderAdapter{

	private final Finder _baseFinder;

	public EmpFinderBase(Finder finder){
	    _baseFinder = finder;
	}

	public EmpFinderBase (MetaRow row, JaxorContext conn){
		this(new BaseFinder(row, conn));
	}

	public EmpFinderBase (JaxorContext conn){
	    this(new EmpMetaRow(),conn);
	}

	public Finder getFinder(){
	    return _baseFinder;
	}

	    public EmpEntity newInstance( final Long empno ) {
        EmpBase result = (EmpBase)_baseFinder.newInstance();
        result.init(empno);
        getFinder().registerNew(result);
        return result;
    }



    public EmpEntity selectByEmpno(final Long empno){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.LongMapper(), empno);
	    return (EmpEntity) getFinder().selectByPrimaryKey(params, false);
    }

    public EmpEntity selectByEmpno(final Long empno, boolean useProxy){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.LongMapper(), empno);
	    return (EmpEntity) getFinder().selectByPrimaryKey(params, useProxy);
    }

public EmpEntity selectByPrimaryKey(final Long empno){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.LongMapper(), empno);
	    return (EmpEntity) getFinder().selectByPrimaryKey(params, false);
    }

public EmpEntity selectByPrimaryKey(final Long empno, boolean useProxy){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.LongMapper(), empno);
	    return (EmpEntity) getFinder().selectByPrimaryKey(params, useProxy);
    }

public boolean entityExists(final Long empno){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.LongMapper(), empno);
	    return getFinder().entityExists(params);
    }


    public EmpList findAll(){
        return find("");
    }


    public EmpResultSet selectByEnameResultSet(final String ename){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.StringMapper(), ename);
        return findResultSet("where ename=?", params);
    }

    public EmpList selectByEnameList(final String ename){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.StringMapper(), ename);
        return find("where ename=?", params);
    }

    public EmpEntity selectByEname(final String ename){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.StringMapper(), ename);
        return findUnique("where ename=?", params, false);
    }

    public EmpEntity selectByEname(final String ename, boolean useProxy){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.StringMapper(), ename);
        return findUnique("where ename=?", params, useProxy);
    }

    public EmpResultSet selectByJobResultSet(final String job){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.StringMapper(), job);
        return findResultSet("where job=?", params);
    }

    public EmpList selectByJobList(final String job){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.StringMapper(), job);
        return find("where job=?", params);
    }

    public EmpEntity selectByJob(final String job){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.StringMapper(), job);
        return findUnique("where job=?", params, false);
    }

    public EmpEntity selectByJob(final String job, boolean useProxy){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.StringMapper(), job);
        return findUnique("where job=?", params, useProxy);
    }

    public EmpResultSet selectByMgrResultSet(final Long mgr){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.LongMapper(), mgr);
        return findResultSet("where mgr=?", params);
    }

    public EmpList selectByMgrList(final Long mgr){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.LongMapper(), mgr);
        return find("where mgr=?", params);
    }

    public EmpEntity selectByMgr(final Long mgr){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.LongMapper(), mgr);
        return findUnique("where mgr=?", params, false);
    }

    public EmpEntity selectByMgr(final Long mgr, boolean useProxy){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.LongMapper(), mgr);
        return findUnique("where mgr=?", params, useProxy);
    }

    public EmpResultSet selectByHiredateResultSet(final java.sql.Date hiredate){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.DateMapper(), hiredate);
        return findResultSet("where hiredate=?", params);
    }

    public EmpList selectByHiredateList(final java.sql.Date hiredate){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.DateMapper(), hiredate);
        return find("where hiredate=?", params);
    }

    public EmpEntity selectByHiredate(final java.sql.Date hiredate){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.DateMapper(), hiredate);
        return findUnique("where hiredate=?", params, false);
    }

    public EmpEntity selectByHiredate(final java.sql.Date hiredate, boolean useProxy){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.DateMapper(), hiredate);
        return findUnique("where hiredate=?", params, useProxy);
    }

    public EmpResultSet selectBySalResultSet(final Long sal){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.LongMapper(), sal);
        return findResultSet("where sal=?", params);
    }

    public EmpList selectBySalList(final Long sal){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.LongMapper(), sal);
        return find("where sal=?", params);
    }

    public EmpEntity selectBySal(final Long sal){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.LongMapper(), sal);
        return findUnique("where sal=?", params, false);
    }

    public EmpEntity selectBySal(final Long sal, boolean useProxy){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.LongMapper(), sal);
        return findUnique("where sal=?", params, useProxy);
    }

    public EmpResultSet selectByCommResultSet(final Long comm){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.LongMapper(), comm);
        return findResultSet("where comm=?", params);
    }

    public EmpList selectByCommList(final Long comm){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.LongMapper(), comm);
        return find("where comm=?", params);
    }

    public EmpEntity selectByComm(final Long comm){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.LongMapper(), comm);
        return findUnique("where comm=?", params, false);
    }

    public EmpEntity selectByComm(final Long comm, boolean useProxy){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.LongMapper(), comm);
        return findUnique("where comm=?", params, useProxy);
    }

    public EmpResultSet selectByDeptnoResultSet(final Long deptno){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.LongMapper(), deptno);
        return findResultSet("where deptno=?", params);
    }

    public EmpList selectByDeptnoList(final Long deptno){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.LongMapper(), deptno);
        return find("where deptno=?", params);
    }

    public EmpEntity selectByDeptno(final Long deptno){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.LongMapper(), deptno);
        return findUnique("where deptno=?", params, false);
    }

    public EmpEntity selectByDeptno(final Long deptno, boolean useProxy){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.LongMapper(), deptno);
        return findUnique("where deptno=?", params, useProxy);
    }

    public EmpResultSet selectByEmpnoResultSet(final Long empno){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.LongMapper(), empno);
        return findResultSet("where empno=?", params);
    }

    public EmpList selectByEmpnoList(final Long empno){
        QueryParams params = new QueryParams();
	    params.add(new net.sourceforge.jaxor.mappers.LongMapper(), empno);
        return find("where empno=?", params);
    }


    public EmpList query(String sql, QueryParams p){
        return new EmpList(getFinder().query(sql,p).list());
    }

    public EmpList query(String sql){
        return new EmpList(getFinder().query(sql).list());
    }

    public EmpEntity queryUnique(String sql, QueryParams p, boolean useProxy){
        if(!useProxy)
            return (EmpEntity)getFinder().query(sql, p).entity();
        return (EmpEntity)getFinder().query(sql, p).entityProxy();
    }

    public EmpEntity queryUnique(String sql, boolean useProxy){
        return queryUnique(sql, new QueryParams(), useProxy);
    }

    public EmpList find(String sql){
        return new EmpList(getFinder().find(sql).list());
    }

    public EmpList find(String sql, QueryParams p){
        return new EmpList(getFinder().find(sql,p).list());
    }

    public EmpEntity findUnique(String whereClause, QueryParams p, boolean useProxy){
        if(useProxy)
            return (EmpEntity) getFinder().find(whereClause,p).entityProxy();
        return (EmpEntity) getFinder().find(whereClause,p).entity();
    }

    public EmpEntity findUnique(String whereClause, boolean useProxy){
        return findUnique(whereClause, new QueryParams(), useProxy);
    }

    public EmpResultSet queryResultSet(String sql, QueryParams p){
        return new EmpResultSet(getFinder().query(sql, p).resultSet());
    }

    public EmpResultSet queryResultSet(String sql){
        return new EmpResultSet (getFinder().query(sql).resultSet());
    }

    public EmpResultSet findResultSet(String sql, QueryParams p){
        return new EmpResultSet(getFinder().find(sql, p).resultSet());
    }

    public EmpResultSet findResultSet(String sql){
        return new EmpResultSet (getFinder().find(sql).resultSet());
    }

    public EmpQuery asQuery(String sql){
        return new EmpQuery(getFinder().query(sql));
    }

     public EmpQuery asQuery(String sql, QueryParams p){
        return new EmpQuery(getFinder().query(sql, p));
    }

    public EmpQuery asFindQuery(String sql){
        return new EmpQuery(getFinder().find(sql));
    }

     public EmpQuery asFindQuery(String sql, QueryParams p){
        return new EmpQuery(getFinder().find(sql, p));
    }

}
