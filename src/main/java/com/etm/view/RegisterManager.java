package com.etm.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etm.dao.EmployeeDao;
import com.etm.entity.Employee;

@WebServlet("/register")
public class RegisterManager extends HttpServlet 
{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		//read data from form
		
		String name=req.getParameter("employee-name");
		String email=req.getParameter("employee-email");
		String password=req.getParameter("employee-password");
		String salary=req.getParameter("employee-salary");
		String age=req.getParameter("employee-age");
		String phoneNumber=req.getParameter("employee-phoneNumber");
		
		double salary1=Double.parseDouble(salary);
		int age1=Integer.parseInt(age);
		long phoneNumber1=Long.parseLong(phoneNumber);
		
		// Create Employee object
				Employee employee = new Employee();
				employee.setName(name);
				employee.setEmail(email);
				employee.setPassword(password);
				employee.setSalary(salary1);
				employee.setAge(age1);
				employee.setPhoneNumber(phoneNumber1);
				employee.setRole("Manager");
				
				// Save to DB
				EmployeeDao employeeDao = new EmployeeDao();
				employeeDao.saveEmployee(employee);
				
				PrintWriter writer=resp.getWriter();
				writer.print("<h1>Manager Registered Successfully</h1>");
				
				RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
				dispatcher.include(req, resp);
		
				
				
		
		
		
	}
}
		
			
			
		
			
			
			
			
			
			
			
	