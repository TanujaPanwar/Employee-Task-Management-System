package com.etm.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etm.dao.EmployeeDao;
import com.etm.dao.TaskDao;
import com.etm.entity.Employee;
import com.etm.entity.Status;
import com.etm.entity.Task;
@WebServlet("/updateTask")
public class UpdateTaskStatus extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//read data from form
		 int taskId = Integer.parseInt(req.getParameter("taskId"));
		 TaskDao taskDao = new TaskDao();
		 Task task = taskDao.findTaskById(taskId);
		 PrintWriter writer = resp.getWriter();
		 if(task != null) {
	            
	            task.setTaskStatus(Status.COMPLETED);
                taskDao.updateTask(task);
                writer.print("<h1>TASK UPDATED SUCCESSFULLY</h1>");
	          
		 }
		 else {
	          writer.println("Task not found with ID: " + taskId);
	        }
	}
}
