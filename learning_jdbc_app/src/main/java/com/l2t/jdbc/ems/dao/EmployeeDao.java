package com.l2t.jdbc.ems.dao;

import com.l2t.jdbc.ems.records.DeptStats;
import com.l2t.jdbc.ems.records.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getAllEmployees();
    List<DeptStats> getDeptStats();
    List<Employee> getEmployeeByDept(int deptno);
    Employee getEmployeeById(int empno);
    double getMaxSalaryByDname(String dname);

}
