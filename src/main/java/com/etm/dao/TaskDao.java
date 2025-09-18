package com.etm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.etm.entity.Employee;
import com.etm.entity.Status;
import com.etm.entity.Task;

public class TaskDao {
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public Task saveTask(Task task) {
		entityTransaction.begin();
		entityManager.persist(task);
		entityTransaction.commit();
		return task;
		
	}
	public Task updateTask(Task task) {
		entityTransaction.begin();
		entityManager.merge(task);
		entityTransaction.commit();
		return task;
		
	}
	public Task deleteTask(Task task) {
		entityTransaction.begin();
		entityManager.remove(task);
		entityTransaction.commit();
		return task;
		
	}

		
	
	public Task findTaskById(int taskid) {
		return entityManager.find(Task.class,taskid);
	}
	
	public List<Task> findAllTask(){
		Query query = entityManager.createQuery("select t from Task t");
		List <Task> task = query.getResultList();
		return task;
	}
	public Task deleteTask(int taskId) {
	    entityTransaction.begin();
	    Task task = entityManager.find(Task.class, taskId);
	    if (task != null) {
	        entityManager.remove(task);
	    }
	    entityTransaction.commit();
	    return task;
	}
	 
    public Task updateTask(int taskId) {
    	 entityTransaction.begin();
    	 Task task = entityManager.find(Task.class, taskId);
    	 if (task != null) {
    		 task.setTaskStatus(Status.COMPLETED);
    	 entityManager.merge(task);
    	 }
    	 entityTransaction.commit();
 	    return task; 
           
      
        }
	
	
}
