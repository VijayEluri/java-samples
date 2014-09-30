SELECT EMP.*, DEPT.dname dname_0, DEPT.loc loc_0 FROM EMP, DEPT
WHERE EMP.deptno = DEPT.deptno ORDER BY EMP.empno