package com.l2t.jdbc.ems.dao;

public enum SqlQueries {
    SQL_QUERIES;

    final static String EMP_DETAILS = """
                select
                    e.empno,
                    e.ename,
                    e.job,
                    e.sal,
                    e.deptno,
                    d.dname,
                    d.loc
                from
                    emp e
                inner join dept d
                on
                    e.deptno = d.deptno;
            """;

     final static String EMP_DETAILS_BY_DEPTNO = """
                select
                    e.empno,
                    e.ename,
                    e.job,
                    e.sal,
                    e.deptno,
                    d.dname,
                    d.loc
                from
                    emp e
                inner join dept d
                on
                    e.deptno = d.deptno
                where
                    e.deptno = ?;
            """;

    final static String EMP_DETAILS_BY_EMPNO = """
                select
                    e.empno,
                    e.ename,
                    e.job,
                    e.sal,
                    e.deptno,
                    d.dname,
                    d.loc
                from
                    emp e
                inner join dept d
                on
                    e.deptno = d.deptno
                where
                    e.empno = ?;
            """;

    final static String DEPT_STATS = """
            select
            	d.deptno,
            	d.dname,
            	d.loc,
            	count(1),
            	max(e.sal) as max_sal,
            	min(e.sal) as min_sal,
            	sum(e.sal) as total_sal
            from
            	emp e
            inner join dept d on
            	e.deptno = d.deptno
            group by
            	d.deptno;

            """;

    final static String CALL_MAX_SALARY_BY_DNAME = "{ ? = call get_max_salary_by_dname(?) }";

}
