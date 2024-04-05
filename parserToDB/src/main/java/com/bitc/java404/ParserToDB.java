package com.bitc.java404;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ParserToDB {

    public void insertDB() {
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
            pstmt.setString(1, "test3");
            pstmt.setString(2, "1234");
            pstmt.setString(3, "tester3");
            pstmt.setString(4, "test3.naver.com");
            pstmt.setString(5, "01010002000");
            pstmt.setString(6, "seoul");

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
}
