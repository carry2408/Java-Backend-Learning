package com.vr.demo.controller;

import com.google.gson.Gson;
import com.vr.demo.dao.StudentDAO;
import com.vr.demo.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends HttpServlet
{
    private final StudentDAO studentDAO = new StudentDAO();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        Gson gson = new Gson();
        Student student =
                gson.fromJson(
                        request.getReader(),
                        Student.class
                );

        try {
             if (studentDAO.addStudent(student))
             {
                 response.getWriter().println("Studend added successfully");
                 response.setStatus(HttpServletResponse.SC_OK);
             }
             else
             {
                 response.getWriter().println("Studend already exists");
                 response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
             }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    // get method
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        String idString = (request.getParameter("id"));
        Gson gson = new Gson();

        if (idString == null)
        {
            try {
                List<Student> studentList =studentDAO.getAllStudents();
                if (studentList.isEmpty()){
                    response.getWriter().println("No students found");

                }
                else
                {
                    String json = gson.toJson(studentList);
                    response.setContentType("application/json");
                    response.getWriter().println(json);
                    response.setStatus(HttpServletResponse.SC_OK);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        else
        {
            int id = Integer.parseInt(idString);
            try {
                Student student = studentDAO.getStudentById(id);
              if (student != null)
              {
                  String json = gson.toJson(student);
                  response.setContentType("application/json");
                    response.getWriter().println(json);
                    response.setStatus(HttpServletResponse.SC_OK);
              }
              else
                {
                    response.getWriter().println("Student not found");

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // PUT
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
       Gson gson = new Gson();
        Student student = gson.fromJson(request.getReader(), Student.class);

        try {
            if (studentDAO.updateStudent(student)){
                response.getWriter().println("Student updated successfully");
                response.setStatus(HttpServletResponse.SC_OK);
            }
            else
            {
                response.getWriter().println("Student not found");
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //delete
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            if (studentDAO.deleteStudentById(id)){
                response.getWriter().println("Student deleted successfully");
                response.setStatus(HttpServletResponse.SC_OK);
            }
            else
            {
             response.getWriter().println("Student not found");
             response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

