package com.l2t.jdbc;

import com.l2t.jdbc.ems.util.ConnectionUtil;

import java.sql.*;

public class ConnectingWithDatabase {

    public static void main(String[] args) {

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = ConnectionUtil.getConnection();
            String sql = "select empno, ename, job, sal from emp";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " +
                        rs.getString(2) + " " +
                        rs.getString(3) + " " +
                        rs.getDouble(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(con, st, rs);
        }

    }
}
