package com.sush.springjdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.sush.springjdbc.model.Student;

public class StudentJdbcTemplate implements StudentDAO {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds ;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}

	@Override
	public void create(String name, Integer age) {
		String SQL ="insert into Student(name,age) values(?,?)";
		jdbcTemplateObject.update(SQL,name,age);
		
		System.out.println("Created Student Name : " + name + " Age : " + age);
	}

	@Override
	public Student getStudent(Integer id) {
		
		String SQL = "select * from Student where id =?";
		Student student = (Student) jdbcTemplateObject.queryForObject(SQL, new Object[] {id},new StudentMapper()); 
		return student;
	}

	@Override
	public List<Student> listStudent() {
		String SQL = "select * from Student ";
		List<Student> students = jdbcTemplateObject.query(SQL,  new StudentMapper());
		return students;
	}

	@Override
	public void delete(Integer id) {
		String SQL = "delete from Student where id = ?";
		jdbcTemplateObject.update(SQL, id);
		
		System.out.println("Deleted Student with id : " + id);
	
	}

	@Override
	public void update( Integer age,Integer id) {
		
		String SQL ="update Student set age= ? where id = ?";
		jdbcTemplateObject.update(SQL,age,id);
		
		System.out.println("Updated Student with id : " + id);
	}

}
