package com.cognizant.service;

import java.util.List;

import com.cognizant.model.Student;

public interface StudentService {

	public List<Student> findAll();
	
	public List<Student> findByName(String name);

	public int create(Student student);

	public int update(Student student);

	public int delete(int id);
	
	public int countStudent();

}