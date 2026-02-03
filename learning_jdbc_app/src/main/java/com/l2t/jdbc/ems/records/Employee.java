package com.l2t.jdbc.ems.records;

public record Employee(int empno,
                       String ename,
                       String job,
                       double sal,
                       int deptno,
                       String dname,
                       String loc) {
}


