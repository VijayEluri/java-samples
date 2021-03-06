/*
 * Copyright 2004-2006 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package examples.dao;

import java.util.List;

public interface EmployeeAutoDao {

    public Class BEAN = Employee.class;

    public List getAllEmployees();

    public String getEmployeeByJobDeptno_ARGS = "job, deptno";

    public List getEmployeeByJobDeptno(String job, Integer deptno);

    public String getEmployeeByEmpno_ARGS = "empno";

    public Employee getEmployeeByEmpno(int empno);

    public String getEmployeesBySal_QUERY = "sal BETWEEN ? AND ? ORDER BY empno";

    public List getEmployeesBySal(float minSal, float maxSal);

    public String getEmployeeByDname_ARGS = "dname_0";

    public List getEmployeeByDname(String dname);

    public List getEmployeesBySearchCondition(EmployeeSearchCondition dto);

    public void update(Employee employee);
}