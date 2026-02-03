package com.l2t.jdbc.ems.dao;

import com.l2t.jdbc.ems.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

record Contact(int id, String name, String email, String mobile) {
}

public class ContactDao {


    // Create table contact id, name, email, mobile

    public void createContactTable() {
        String sql = "create table if not exists contact(id int primary key, name varchar(100), email varchar(100), mobile varchar(100))";
        Connection con = null;
        Statement st = null;
        try {
            con = ConnectionUtil.getConnection();
            st = con.createStatement();
            st.execute(sql);
            System.out.println("Table created successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(con, st);
        }
    }

    public void addContact(Contact contact) {
        String sql = "insert into contact(id,name,email,mobile) values (?, ?, ?, ?)";
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = ConnectionUtil.getConnection();
            st = con.prepareStatement(sql);
            st.setInt(1, contact.id());
            st.setString(2, contact.name());
            st.setString(3, contact.email());
            st.setString(4, contact.mobile());
            int count = st.executeUpdate();
            System.out.println(count + " row(s) inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(con, st);
        }
    }

    public List<Contact> getAllContacts() {
        String sql = "select id, name, email, mobile from contact";
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        List<Contact> contacts = new ArrayList<>();
        try {
            con = ConnectionUtil.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                contacts.add(new Contact(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            return contacts;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(con, st, rs);
        }
        return contacts;
    }

    public void deleteContact(int id){

    }
    public Contact getContactById(int id){
        return null;
    }
    public List<Contact> search(String name){
        return null;
    }
    public void updateEmailAndName(int id, String name, String email){
        // Get contact with id and update rest of fields
    }

    public void updateMobile(int id,String mobile){
        // Get contact with id and update mobile if id is present and ensure mobile is not null
    }

    public static void main(String[] args) {

        ContactDao contactDao = new ContactDao();
        //contactDao.createContactTable();

        Contact contact = new Contact(1002, "Krish", "krish@abc.com", "8876543210");
        contactDao.addContact(contact);
    }

}
