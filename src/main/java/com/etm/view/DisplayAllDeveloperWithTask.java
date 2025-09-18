package com.etm.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etm.dao.EmployeeDao;
import com.etm.entity.Employee;
import com.etm.entity.Task;

@WebServlet("/viewDeveloperWithTask")
public class DisplayAllDeveloperWithTask extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		 EmployeeDao employeeDao = new EmployeeDao();
	        List<Employee> developers = employeeDao.findAllDevelopersWithTasks();

	        // set developers list in request scope
	        req.setAttribute("developers", developers);

	        // forward to JSP
	        req.getRequestDispatcher("developersWithTasks.jsp").forward(req, resp);
	}
	

}
