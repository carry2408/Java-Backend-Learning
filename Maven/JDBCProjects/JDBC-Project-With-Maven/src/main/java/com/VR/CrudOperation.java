package com.VR;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CrudOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection connection = null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            connection = JdbcUtils.getConnection();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        String sql = "Insert into studentinfo(name,age) values(?,?)";
       try {
           ps = JdbcUtils.getPreparedStatement(connection,sql);
           System.out.println("Enter no of students:");
           int noOfStudents = sc.nextInt();
           int row=0;
           for( int i=0;i<noOfStudents;i++ ) {
           sc.nextLine();
               System.out.println("Enter name:");
               String name = sc.nextLine();
               ps.setString(1,name);
               System.out.println("Enter age:");
               int age = sc.nextInt();
               ps.setInt(2,age);
               row = ps.executeUpdate();
           }
           if(row>0){
               System.out.println("Successfully inserted");
           }
           else{
               System.out.println("Error in inserting");
           }

           String sql1 ="select  * from studentinfo ";
           ps = JdbcUtils.getPreparedStatement(connection,sql1);
           rs=ps.executeQuery();
           while (rs.next()) {
               int id = rs.getInt("id");
               String name = rs.getString("name");
               int age = rs.getInt("age");
               System.out.println(id+"\t"+name+"\t"+age);
           }


       } catch (SQLException e) {
           e.printStackTrace();
       }

        // close all resources
        JdbcUtils.close(ps,connection,rs);
    }
}
