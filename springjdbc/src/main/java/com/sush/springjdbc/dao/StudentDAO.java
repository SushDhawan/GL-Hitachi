package com.sush.springjdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import com.sush.springjdbc.model.Student;

public interface StudentDAO {
	
	
	public void setDataSource(DataSource ds) ;   // to access the Student Table 
	
	public void create(String name, Integer age);   //to add a record in Student table 
	
	public Student getStudent(Integer id);    // to fetch one Student for a given id
	
	public List<Student> listStudent();        // fetch all records in the table 
	
	public void  delete(Integer id);			// to delete a student with the given id
	
	public void update(Integer age, Integer id) ;  // to update a given record 

}
