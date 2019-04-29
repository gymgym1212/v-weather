package com.example.bigdata.jdbc;

import java.sql.*;

public class TestJDBC {
    private Connection conn;

    public TestJDBC() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager
                    .getConnection(
                            "jdbc:mysql://47.96.3.244:3306/bigdata?characterEncoding=UTF-8",
                            "root", "youpassword");

            System.out.println("连接成功，获取连接对象： " + conn);

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void createScreen() {
        try(Statement stmt = conn.createStatement();)
        {
            String sql1 = "select screen_id from screens order by screen_id DESC limit 1;";
            ResultSet rs = stmt.executeQuery(sql1);
            int final_screen_num = 0;
            while(rs.next()) {
                 final_screen_num = rs.getInt(1) + 1;
            }
            System.out.println(final_screen_num);
            String screen_url = "http://localhost:8000/screen" + final_screen_num;

            String sql2 = "insert into screens values (null,?,?,?,null);";

            PreparedStatement ps;
            ps = conn.prepareStatement(sql2);

            ps.setInt(1, final_screen_num);
            ps.setString(2, "test");
            ps.setString(3, screen_url);
            ps.execute();

        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager
                    .getConnection(
                            "jdbc:mysql://47.96.3.244:3306/bigdata?characterEncoding=UTF-8",
                            "root", "youpassword");

            System.out.println("连接成功，获取连接对象： " + conn);

/*            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("show tables;");

            while(rs.next()){
                System.out.println(rs.getString(1));
            }*/

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


}
