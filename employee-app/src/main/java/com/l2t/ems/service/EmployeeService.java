package com.l2t.ems.service;

import com.l2t.ems.domain.Dept;
import com.l2t.ems.domain.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    void addEmployee(Employee employee);

    List<Employee> getEmployees();

    Map<Dept, List<Employee>> getEmployeeByDept();

    boolean deleteEmployee(String id);

    Employee updateEmployee(Employee emp);

    List<Employee> search(String name);

    Employee getEmployee(String id);
}