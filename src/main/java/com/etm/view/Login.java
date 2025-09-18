package com.etm.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etm.dao.EmployeeDao;
import com.etm.entity.Employee;

@WebServlet("/login")
public class Login extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("employeeEmail");
		String password=req.getParameter("employeePassword");
		
		EmployeeDao employeeDao = new EmployeeDao();
		Employee employee = employeeDao.findEmployeeByEmailAndPassword(email,password);
		if(employee!=null) {
			if(employee.getRole().equalsIgnoreCase("manager")) {
				RequestDispatcher dispatcher=req.getRequestDispatcher("manager.html");
				dispatcher.forward(req, resp);
				//add developer
				//assign task
				//view all developer with task
				//delete developer
			}
			else {
				//for employee
				RequestDispatcher dispatcher=req.getRequestDispatcher("employee.html");
				dispatcher.forward(req, resp);
				//1. view task
				//2.change task status
				//3.updateData
				
				//to change data
				//afterlogin---take task id from form---create fetchTaskById(id) &
				//after fetching task---setStatus(Status.COMPLETED)----updateTask
				//updateTask(Task) from TaskDao
			}
		}
	}

}
