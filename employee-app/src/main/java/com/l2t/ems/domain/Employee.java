package com.l2t.ems.domain;

public class Employee {

    private String id;   // CT1001
    private String name;
    private String email;
    private String qualification;
    private Dept dept;

    public Employee(String name, String email, String qualification, Dept dept) {
        this.name = name;
        this.email = email;
        this.qualification = qualification;
        this.dept = dept;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Dept getDept() {
        return dept;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getEmail() {
        return email;
    }

    public String getQualification() {
        return qualification;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", qualification='" + qualification + '\'' +
                ", dept=" + dept +
                '}';
    }
}