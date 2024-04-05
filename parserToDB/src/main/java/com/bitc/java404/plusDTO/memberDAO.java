package com.bitc.java404.plusDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class memberDAO {

    public void insertDB(memberDTO member) {

        Connection conn = null;

        String dbUrl = "jdbc:mysql://localhost:3306/testdb?characterEncoding=utf8&serverTimezone=UTC";
        String dbUser = "java404";
        String dbPass = "java404";

        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl,dbUser,dbPass);

            String sql = "insert into member (user_id, user_pw, user_name, user_email, user_phone, user_addr) values (?, ?, ?, ?, ?, ?);";

            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, member.getUser_id());
            pstmt.setString(2, member.getUser_pw());
            pstmt.setString(3, member.getUser_name());
            pstmt.setString(4, member.getUser_email());
            pstmt.setString(5, member.getUser_phone());
            pstmt.setString(6, member.getUser_addr());

            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("added " + result + " data(s)");
            } else {
                System.out.println("Fail adding data");
            }

        } catch (SQLException e) {
            System.out.println("ERROR");
            System.out.println("SQLException : " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());

        } finally {
            try {
                if (conn != null) {conn.close();}
            } catch (Exception e) {

            }
        }
    }



    public void updateDB(memberDTO member) {
        Connection conn = null;
        String dbUrl = "jdbc:mysql://localhost:3306/testdb";
        String dbUser = "java404";
        String dbPass = "java404";

        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl,dbUser,dbPass);

            String sql = "update member set ";
            sql += "user_name = ?, user_email = ?, user_phone = ? ";
            sql += "where user_id = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getUser_name());
            pstmt.setString(2, member.getUser_email());
            pstmt.setString(3, member.getUser_phone());
            pstmt.setString(4, member.getUser_id());

            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("update " + result + " data(s)");
            } else {
                System.out.println("No updated data");
            }
        } catch (SQLException e) {
            System.out.println("ERROR");
            System.out.println("SQLException : " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());

        } finally {
            try {
                if (pstmt != null) {pstmt.close();}
                if (conn != null) {conn.close();}

            } catch (Exception e){

            }
        }
    }
}
