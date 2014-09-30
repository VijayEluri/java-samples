
package jaxor.sample;

import java.sql.*;
import net.sourceforge.jaxor.*;


public class EmpFinder{

    public static EmpEntity newInstance( final Long empno ) {
        return getInstance().newInstance( empno );
    }

    public static String getBaseQuerySQL(){
        return getInstance().getFinder().getBaseQuerySQL();
    }

    public static final EmpFinderBase getInstance(){
        net.sourceforge.jaxor.api.JaxorContext context = JaxorSession.getJaxorContext();
        if(context == null)
            throw new NullPointerException("JaxorContext is not defined. Please set it with JaxorSession.begin");
        return (EmpFinderBase)context.getFinder(EmpFinderBase.class);
    }


    public static EmpEntity selectByPrimaryKey(final Long empno){
        return getInstance().selectByPrimaryKey(empno, false);
    }

    public static EmpEntity selectByPrimaryKey(final Long empno, boolean useProxy){
        return getInstance().selectByPrimaryKey(empno, useProxy);
    }

    public static boolean entityExists(final Long empno){
        return getInstance().entityExists(empno);
    }

    public static EmpList selectAll(){
        return getInstance().findAll();
    }

        
        
    public static EmpResultSet selectByEnameResultSet(final String ename){
        return getInstance().selectByEnameResultSet(ename);
    }

    public static EmpList selectByEnameList(final String ename){
        return getInstance().selectByEnameList(ename);
    }

    public static EmpEntity selectByEname(final String ename){
        return getInstance().selectByEname(ename, false);
    }

    public static EmpEntity selectByEname(final String ename, boolean useProxy){
        return getInstance().selectByEname(ename, useProxy);
    }
        
        
    public static EmpResultSet selectByJobResultSet(final String job){
        return getInstance().selectByJobResultSet(job);
    }

    public static EmpList selectByJobList(final String job){
        return getInstance().selectByJobList(job);
    }

    public static EmpEntity selectByJob(final String job){
        return getInstance().selectByJob(job, false);
    }

    public static EmpEntity selectByJob(final String job, boolean useProxy){
        return getInstance().selectByJob(job, useProxy);
    }
        
        
    public static EmpResultSet selectByMgrResultSet(final Long mgr){
        return getInstance().selectByMgrResultSet(mgr);
    }

    public static EmpList selectByMgrList(final Long mgr){
        return getInstance().selectByMgrList(mgr);
    }

    public static EmpEntity selectByMgr(final Long mgr){
        return getInstance().selectByMgr(mgr, false);
    }

    public static EmpEntity selectByMgr(final Long mgr, boolean useProxy){
        return getInstance().selectByMgr(mgr, useProxy);
    }
        
        
    public static EmpResultSet selectByHiredateResultSet(final java.sql.Date hiredate){
        return getInstance().selectByHiredateResultSet(hiredate);
    }

    public static EmpList selectByHiredateList(final java.sql.Date hiredate){
        return getInstance().selectByHiredateList(hiredate);
    }

    public static EmpEntity selectByHiredate(final java.sql.Date hiredate){
        return getInstance().selectByHiredate(hiredate, false);
    }

    public static EmpEntity selectByHiredate(final java.sql.Date hiredate, boolean useProxy){
        return getInstance().selectByHiredate(hiredate, useProxy);
    }
        
        
    public static EmpResultSet selectBySalResultSet(final Long sal){
        return getInstance().selectBySalResultSet(sal);
    }

    public static EmpList selectBySalList(final Long sal){
        return getInstance().selectBySalList(sal);
    }

    public static EmpEntity selectBySal(final Long sal){
        return getInstance().selectBySal(sal, false);
    }

    public static EmpEntity selectBySal(final Long sal, boolean useProxy){
        return getInstance().selectBySal(sal, useProxy);
    }
        
        
    public static EmpResultSet selectByCommResultSet(final Long comm){
        return getInstance().selectByCommResultSet(comm);
    }

    public static EmpList selectByCommList(final Long comm){
        return getInstance().selectByCommList(comm);
    }

    public static EmpEntity selectByComm(final Long comm){
        return getInstance().selectByComm(comm, false);
    }

    public static EmpEntity selectByComm(final Long comm, boolean useProxy){
        return getInstance().selectByComm(comm, useProxy);
    }
        
        
    public static EmpResultSet selectByDeptnoResultSet(final Long deptno){
        return getInstance().selectByDeptnoResultSet(deptno);
    }

    public static EmpList selectByDeptnoList(final Long deptno){
        return getInstance().selectByDeptnoList(deptno);
    }

    public static EmpEntity selectByDeptno(final Long deptno){
        return getInstance().selectByDeptno(deptno, false);
    }

    public static EmpEntity selectByDeptno(final Long deptno, boolean useProxy){
        return getInstance().selectByDeptno(deptno, useProxy);
    }
        
        
    public static EmpResultSet selectByEmpnoResultSet(final Long empno){
        return getInstance().selectByEmpnoResultSet(empno);
    }

    public static EmpList selectByEmpnoList(final Long empno){
        return getInstance().selectByEmpnoList(empno);
    }

    public static EmpEntity selectByEmpno(final Long empno){
        return getInstance().selectByEmpno(empno, false);
    }

    public static EmpEntity selectByEmpno(final Long empno, boolean useProxy){
        return getInstance().selectByEmpno(empno, useProxy);
    }

    public static EmpEntity load(ResultSet rs) throws SQLException {
        return (EmpEntity) getInstance().getFinder().load(rs);
    }

    public static EmpEntity loadFromOuterJoin(ResultSet rs) throws SQLException {
        try {
            return load(rs);
        } catch (SQLValidationException expectedObjectNull) {
            return null;
        }
    }   

    public static EmpList query(final String sql, QueryParams args) {
        return getInstance().query(sql, args);
    }

    public static EmpEntity queryUnique(final String sql, QueryParams args, final boolean lazy) {
        return getInstance().queryUnique(sql, args, lazy);
    }
    
    public static EmpList query(final String sql) {
        return getInstance().query(sql);
    }

    public static EmpEntity queryUnique(final String sql,final boolean lazy) {
        return getInstance().queryUnique(sql, lazy);
    }

    public static EmpList find(final String whereClause, QueryParams args) {
        return getInstance().find(whereClause, args);
    }

    public static EmpEntity findUnique(final String whereClause, QueryParams args, final boolean lazy) {
        return getInstance().findUnique(whereClause, args, lazy);
    }

    public static EmpList find(final String whereClause) {
        return getInstance().find(whereClause);
    }

    public static EmpEntity findUnique(final String whereClause,final boolean lazy) {
        return getInstance().findUnique(whereClause, lazy);
    }


}
