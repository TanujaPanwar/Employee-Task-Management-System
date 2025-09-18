package com.etm.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etm.dao.EmployeeDao;
import com.etm.entity.Employee;
@WebServlet("/updateData")
public class UpdateData extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// read data from form
        int employeeId = Integer.parseInt(req.getParameter("employeeId"));

        EmployeeDao employeeDao = new EmployeeDao();
        Employee emp = employeeDao.findEmployeeById(employeeId); 
        PrintWriter writer = resp.getWriter();
        if (emp != null) {
        	req.setAttribute("employee", emp); 
            RequestDispatcher dispatcher=req.getRequestDispatcher("updationForm.jsp");
			dispatcher.forward(req, resp);
        } else {
          writer.println("Employee not found with ID: " + employeeId);
        }
	}
	

}
