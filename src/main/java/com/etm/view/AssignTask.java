package com.etm.view;

import java.io.IOException;
import java.util.List;

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
@WebServlet("/assignTask")
public class AssignTask extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//read data from form
		String taskname=req.getParameter("taskName");
		int duration=Integer.parseInt(req.getParameter("taskDuration"));
		int employeeId=Integer.parseInt(req.getParameter("employeeId"));
		
		
		//craeting task
		//creating task object
		Task task=new Task();
		//set data
		task.setTaskName(taskname);
		task.setDuration(duration);
		task.setTaskStatus(Status.ASSIGNED); //table--integer value  (call like static method)
		
		//save task object
		TaskDao taskDao=new TaskDao();
		taskDao.saveTask(task);
		
		//to assigntask to employee
		//fetch employee by id
		EmployeeDao employeeDao=new EmployeeDao();
		Employee employee=employeeDao.findEmployeeById(employeeId);
		if(employee!=null) {
			
		
		//fetch all old task list for that employee
		List<Task> list = employeeDao.findTaskByEmpId(employeeId);
		//add new task to same old list
		list.add(task);
		//set task list to employee
		employee.setTasks(list);
		//update employee
		employeeDao.updateEmployee(employee);
		}
		else
		{
			System.out.println("Invalid Employee Id");
		}
	}

}
