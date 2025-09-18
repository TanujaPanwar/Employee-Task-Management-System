package com.etm.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter

@Table(name="employee_details")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name ="employee_name")
	private String name;
	private int age;
	private double salary;
	@Column(unique = true)
	private String email;
	private String password;
	@Column(length = 10)
	private long phoneNumber;
	private String role;
	
	//mapping
	@OneToMany
	private List<Task> tasks;
	

}


