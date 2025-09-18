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

@WebServlet("/changePassword")
public class ChangePassword extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 // read data from change password page
        String password = req.getParameter("password");
       int id=Integer.parseInt(req.getParameter("id"));
       
       EmployeeDao employeeDao = new EmployeeDao();
       int updated = employeeDao.updatePasswordByPasswordAndId(password, id);

       PrintWriter writer = resp.getWriter();
       if(updated > 0) {
           writer.print("<h1>PASSWORD UPDATED</h1>");
       } else {
           writer.print("<h1>RESET AGAIN</h1>");
       }
	}

}
