package com.l2t.ems.service;

import com.l2t.ems.domain.Dept;
import com.l2t.ems.domain.Employee;

import java.util.List;
import java.util.Map;

public class EmployeeDbImpl implements EmployeeService{

    public EmployeeDbImpl(){
        System.out.println("DB implementation is used");
    }

    @Override
    public void addEmployee(Employee employee) {

    }

    @Override
    public List<Employee> getEmployees() {
        return List.of();
    }

    @Override
    public Map<Dept, List<Employee>> getEmployeeByDept() {
        return Map.of();
    }

    @Override
    public boolean deleteEmployee(String id) {
        return false;
    }

    @Override
    public Employee updateEmployee(Employee emp) {
        return null;
    }

    @Override
    public List<Employee> search(String name) {
        return List.of();
    }

    @Override
    public Employee getEmployee(String id) {
        return null;
    }
}
