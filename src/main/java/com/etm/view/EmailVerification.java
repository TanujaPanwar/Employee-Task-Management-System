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

@WebServlet("/verifyEmail")
public class EmailVerification extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//read data from login page
				String email=req.getParameter("takeemail");
				
				EmployeeDao employeeDao = new EmployeeDao();
				Employee employee = employeeDao.findEmployeeByEmail(email);
				if(employee!=null) {
					RequestDispatcher dispatcher=req.getRequestDispatcher("takePassword.html");
					dispatcher.forward(req, resp);
				}
				 else {
					 PrintWriter writer=resp.getWriter();
					 writer.print("<h1>INVALID EMAIL ID OR REGISTER FIRST</h1>");
				 }
			        	
			        }
}
