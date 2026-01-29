package com.l2t.ems.service;


import com.l2t.ems.domain.Dept;
import com.l2t.ems.domain.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeInMemoryImpl implements EmployeeService {

    private static int counter = 1000; // starts before 1001

    private List<Employee> empList = new ArrayList<>();

    private String generateEmployeeId() {
        counter++;
        return "CT" + counter;
    }
    @Override
    public void addEmployee(Employee employee) {
        String id = generateEmployeeId();
        employee.setId(id);
        empList.add(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return empList;
    }

    @Override
    public Map<Dept, List<Employee>> getEmployeeByDept() {
        return empList.stream()
                .collect(Collectors.groupingBy(Employee::getDept));
    }

    @Override
    public boolean deleteEmployee(String id) {
        return empList.removeIf(emp -> emp.getId().equalsIgnoreCase(id));
    }

    @Override
    public Employee updateEmployee(Employee emp) {
        for (Employee e : empList) {
            if (e.getId().equalsIgnoreCase(emp.getId())) {
                e.setName(emp.getName());
                e.setEmail(emp.getDept().name());
                e.setQualification(emp.getDept().name());
                e.setDept(emp.getDept());
                return e;
            }
        }
        return null;
    }

    @Override
    public List<Employee> search(String name) {
        return empList.stream()
                .filter(e -> e.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public Employee getEmployee(String id) {
        return empList
                .stream()
                .filter(e->e.getId().equalsIgnoreCase(id))
                .findFirst()
                .get();
    }
}