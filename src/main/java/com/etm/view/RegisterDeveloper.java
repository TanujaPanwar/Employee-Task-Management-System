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

@WebServlet("/registerDeveloper")
public class RegisterDeveloper extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//read data from form
	
		String name=req.getParameter("dev-name");
		String email=req.getParameter("dev-email");
		String password=req.getParameter("dev-password");
		String salary=req.getParameter("dev-salary");
		String phoneNumber=req.getParameter("dev-phonenumber");
		String age=req.getParameter("dev-age");
		
		int age1=Integer.parseInt(age);
		double salary1=Double.parseDouble(salary);
		long phoneNumber1=Long.parseLong( phoneNumber);
	
		Employee employee = new Employee();
		
		employee.setName(name);
		employee.setEmail(email);
		employee.setPassword(password);
		employee.setSalary(salary1);
		employee.setAge(age1);
		employee.setPhoneNumber(phoneNumber1);
		employee.setRole("Developer");
		
		// Save to DB
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.saveEmployee(employee);
		

		PrintWriter writer=resp.getWriter();
		writer.print("<h1>Developer Registered Successfully</h1>");
		

		//provide him login page
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.html");
    	requestDispatcher.include(req, resp);

}
}
