package com.vr.demo.dao;

import com.google.gson.Gson;
import com.vr.demo.model.Student;
import com.vr.demo.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO
{

    // Api = Post->/student
    public boolean addStudent(Student student) throws SQLException
    {
        String sql = "INSERT INTO STUDENTINFO(NAME,EMAIL,COURSE,AGE) VALUES(?,?,?,?)";
        try(Connection connection = JdbcUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getCourse());
            ps.setInt(4, student.getAge());
            return ps.executeUpdate()>0;
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }

    }

    // Api = GET -> /student?id=ID
    public Student getStudentById(int id) throws SQLException
    {
        String sql = "SELECT * FROM STUDENTINFO WHERE ID = ?";
        try(Connection connection = JdbcUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                Student student = new Student();
                student.setId(rs.getInt("ID"));
                student.setName(rs.getString("NAME"));
                student.setEmail(rs.getString("EMAIL"));
                student.setCourse(rs.getString("COURSE"));
                student.setAge(rs.getInt("AGE"));
                return student;
            }
            else
            {
                return null;
            }
        }
    }

    // getall students Api = GET -> /student
    public List<Student> getAllStudents() throws SQLException
    {
        String sql = "SELECT * FROM STUDENTINFO";
        try(Connection connection = JdbcUtil.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql))
        {
            ResultSet rs = ps.executeQuery();
            List<Student> students = new ArrayList<>();
            while (rs.next())
            {
                Student student = new Student();
                student.setId(rs.getInt("ID"));
                student.setName(rs.getString("NAME"));
                student.setEmail(rs.getString("EMAIL"));
                student.setCourse(rs.getString("COURSE"));
                student.setAge(rs.getInt("AGE"));
                students.add(student);
            }
            return students;
        }
    }

    // update a student method
    //Api = PUT -> /student?id=ID
    public boolean updateStudent(Student student) throws SQLException {

        String sql = "UPDATE STUDENTINFO SET NAME=?, EMAIL=?, COURSE=?, AGE=? WHERE ID=?";

        try (Connection connection = JdbcUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getCourse());
            ps.setInt(4, student.getAge());
            ps.setInt(5, student.getId());

            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteStudentById(int id) throws SQLException
    {
        String sql = "DELETE FROM STUDENTINFO WHERE ID=?";
        try(Connection connection = JdbcUtil.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.setInt(1,id);
            return ps.executeUpdate()>0;
        }
    }
}