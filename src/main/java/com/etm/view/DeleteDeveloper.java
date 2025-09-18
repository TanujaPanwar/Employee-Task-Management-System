package com.etm.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etm.dao.EmployeeDao;
import com.etm.entity.Employee;



@WebServlet("/deleteDeveloper")
public class DeleteDeveloper extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // read data from form
        int employeeId = Integer.parseInt(req.getParameter("employeeId"));

        EmployeeDao employeeDao = new EmployeeDao();
        Employee emp = employeeDao.findEmployeeById(employeeId); 
        PrintWriter writer = resp.getWriter();

        if (emp != null) {
            employeeDao.deleteEmployee(emp);  // delete managed entity
            writer.print("<h1>DELETED SUCCESSFULLY</h1>");
        } else {
            writer.print("<h1>INVALID ID</h1>");
        }
    }
}

