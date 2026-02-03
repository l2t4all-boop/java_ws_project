package com.l2t.jdbc.ems.dao;

import com.l2t.jdbc.ems.records.DeptStats;
import com.l2t.jdbc.ems.records.Employee;
import com.l2t.jdbc.ems.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.l2t.jdbc.ems.dao.SqlQueries.*;

public class EmployeeDaoImp implements EmployeeDao{

    @Override
    public List<Employee> getAllEmployees() {
        return List.of();
    }

    @Override
    public List<DeptStats> getDeptStats() {
        return List.of();
    }

    @Override
    public List<Employee> getEmployeeByDept(int deptno) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Employee> employees = new ArrayList<>();
        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(EMP_DETAILS_BY_DEPTNO);
            ps.setInt(1, deptno);
            rs = ps.executeQuery();
            while (rs.next()) {
                employees.add(convertRowToEmployee(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(con, ps, rs);
        }
        return employees;
    }

    private Employee convertRowToEmployee(ResultSet rs) {
        try {
           return  new Employee(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getDouble(4),
                    rs.getInt(5),
                    rs.getString(6),
                    rs.getString(7));
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employee getEmployeeById(int empno) {
        return null;
    }

    @Override
    public double getMaxSalaryByDname(String dname) {
        Connection con = null;
        CallableStatement st = null;
        ResultSet rs = null;
        try{
            con = ConnectionUtil.getConnection();
            st =  con.prepareCall(CALL_MAX_SALARY_BY_DNAME);
            st.registerOutParameter(1, Types.NUMERIC);
            st.setString(2, dname);
            st.execute();
            return st.getBigDecimal(1).doubleValue();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(con, st, rs);
        }
        return 0;
    }
}
