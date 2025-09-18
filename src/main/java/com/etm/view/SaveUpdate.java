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

@WebServlet("/saveUpdate")
public class SaveUpdate extends HttpServlet{
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//read data from form
	        int id = Integer.parseInt(req.getParameter("id"));
			String name=req.getParameter("name");
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			String salary=req.getParameter("salary");
			String age=req.getParameter("age");
			String phoneNumber=req.getParameter("phone");
			
			double salary1=Double.parseDouble(salary);
			int age1=Integer.parseInt(age);
			long phoneNumber1=Long.parseLong(phoneNumber);
			
		
			
			
			EmployeeDao employeeDao = new EmployeeDao();
			Employee emp =employeeDao.findEmployeeById(id);
			PrintWriter writer=resp.getWriter();
			if (emp != null) {
	            emp.setName(name);
	            emp.setEmail(email);
	            emp.setPassword(password);
	            emp.setSalary(salary1);
	            emp.setAge(age1);
	            emp.setPhoneNumber(phoneNumber1);

	           employeeDao.updateEmployee(emp); 
	           writer.print("<h1>Updation Success</h1>");
	           
	        } else {
	        	 writer.print("<h1>Employee not found</h1>");
	        }
			
			
			
			
  }
	
}
