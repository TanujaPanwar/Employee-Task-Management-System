package com.etm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.etm.entity.Employee;
import com.etm.entity.Task;


//dao-data access object
public class EmployeeDao {
 
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public Employee saveEmployee(Employee employee) {
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee;
		
	}
	public Employee updateEmployee(Employee employee) {
		entityTransaction.begin();
		entityManager.merge(employee);
		entityTransaction.commit();
		return employee;
		
	}
	public Employee deleteEmployee(Employee employee) {
		entityTransaction.begin();
		entityManager.remove(employee);
		entityTransaction.commit();
		return employee;
		
	}
	public Employee findEmployeeById(int empid) {
		return entityManager.find(Employee.class,empid);
	}
	
	
	
	public List<Employee> findAllEmployee(){
		Query query = entityManager.createQuery("select e from Employee e");
		List <Employee> list = query.getResultList();
		return list;
	}
	public Employee findEmployeeByEmailAndPassword(String email,String password) {
		Query query=entityManager.createQuery
				("select e from Employee e where e.email =?1 and e.password =?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		List <Employee> list = query.getResultList();
		return list.get(0);
		
	}
	public Employee findEmployeeByEmail(String email) {
		Query query=entityManager.createQuery
				("select e from Employee e where e.email =?1 ");
		query.setParameter(1, email);
		List <Employee> list = query.getResultList();
		return list.get(0);
		
	}
	
	
	public int updatePasswordByPasswordAndId(String password, int id) {
	    EntityTransaction transaction = entityManager.getTransaction();
	    int updated = 0;
	    try {
	        transaction.begin();
	        Query query = entityManager.createQuery(
	            "update Employee e set e.password = ?1 where e.id = ?2"
	        );
	        query.setParameter(1, password);
	        query.setParameter(2, id);
	        updated = query.executeUpdate();
	        transaction.commit();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
		return updated;
	    }
	
//	public List<Task> findTaskByEmpId(int id){
//		Employee e=entityManager.find(Employee.class, id);
//		return e.getTasks();
//	}
	public List<Task> findTaskByEmpId(int id) {
	    Employee emp = entityManager.find(Employee.class, id);
	    if (emp != null) {
	        return emp.getTasks(); // tasks must be properly mapped in Employee entity
	    }
	    return null;
	}
	
	public List<Employee> findAllDevelopersWithTasks() {
		Query query=entityManager.createQuery
				("select e from Employee e where e.role = ?1");
				query.setParameter(1, "developer");
		List <Employee> list = query.getResultList();
		return  list;
		
	   
	}
	public Employee deleteEmployee(int empId) {
	    entityTransaction.begin();
	    Employee employee = entityManager.find(Employee.class, empId);
	    if (employee != null) {
	        entityManager.remove(employee);
	    }
	    entityTransaction.commit();
	    return employee;
	}


}
