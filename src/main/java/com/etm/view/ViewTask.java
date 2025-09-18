package com.etm.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etm.dao.EmployeeDao;
import com.etm.entity.Employee;
import com.etm.entity.Task;

@WebServlet("/viewTask")
public class ViewTask extends HttpServlet{
	
	
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//read data

		int id = Integer.parseInt(req.getParameter("id")); 
		 EmployeeDao employeeDao = new EmployeeDao();
		
		 List<Task> list = employeeDao.findTaskByEmpId(id);
		
			 req.setAttribute("emptask", list);
			 
			// req.getRequestDispatcher("/viewTask.jsp").forward(req, resp);
			 
			 RequestDispatcher requestDispatcher =  req.getRequestDispatcher("viewTask.jsp");
			 requestDispatcher.forward(req, resp); 
		 
		
		
	}

}



