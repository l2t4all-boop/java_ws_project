package com.l2t.jdbc.ems;

import com.l2t.jdbc.ems.dao.EmployeeDao;
import com.l2t.jdbc.ems.dao.EmployeeDaoImp;
import com.l2t.jdbc.ems.records.Employee;

import java.util.List;

public class EmployeeManager {

    public static void main(String[] args) {

        EmployeeDao employeeDao = new EmployeeDaoImp();

        List<Employee> employees = employeeDao.getEmployeeByDept(10);

        employees.forEach(System.out::println);

        double maxSalary = employeeDao.getMaxSalaryByDname("SALES");
        System.out.println("Max salary: " + maxSalary);
    }
}
