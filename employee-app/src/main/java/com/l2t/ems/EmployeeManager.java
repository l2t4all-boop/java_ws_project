package com.l2t.ems;

import com.l2t.ems.domain.Dept;
import com.l2t.ems.domain.Employee;
import com.l2t.ems.service.EmployeeDbImpl;
import com.l2t.ems.service.EmployeeInMemoryImpl;
import com.l2t.ems.service.EmployeeService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EmployeeManager {

    public static void main(String[] args) {
        EmployeeService service = null;
        if(args.length > 0) {
            String implType = args[0];
            if (implType.equalsIgnoreCase("db")) {
                service = new EmployeeDbImpl();
            } else {
                service = new EmployeeInMemoryImpl();
            }
        }else{
            service = new EmployeeInMemoryImpl();
        }

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n====== Employee Management System ======");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. View Employees By Department");
            System.out.println("4. Search Employee By Name");
            System.out.println("5. Delete Employee");
            System.out.println("6. Get employee by id");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {

                case 1 -> {

                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Qualification: ");
                    String qual = sc.nextLine();

                    System.out.print("Dept (CSE/ISE/ECE): ");
                    Dept dept = Dept.valueOf(sc.next().toUpperCase());

                    service.addEmployee(new Employee(name, email, qual, dept));
                    System.out.println("✅ Employee added");
                }

                case 2 -> {
                    List<Employee> list = service.getEmployees();
                    list.forEach(System.out::println);
                }

                case 3 -> {
                    Map<Dept, List<Employee>> map = service.getEmployeeByDept();
                    map.forEach((d, e) -> {
                        System.out.println(d + " : " + e);
                    });
                }

                case 4 -> {
                    System.out.print("Enter name to search: ");
                    String name = sc.next();
                    service.search(name).forEach(System.out::println);
                }

                case 5 -> {
                    System.out.print("Enter employee id: ");
                    String id = sc.nextLine();
                    System.out.println(service.deleteEmployee(id)
                            ? "🗑 Employee deleted"
                            : "❌ Employee not found");
                }
                case 6 ->{
                    System.out.print("Enter employee id: ");
                    String id = sc.nextLine();
                    Employee emp = service.getEmployee(id);
                    System.out.println(emp);
                }

                case 7 -> {
                    System.out.println("👋 Exiting...");
                    System.exit(0);
                }

                default -> System.out.println("Invalid choice");
            }
        }
    }
}