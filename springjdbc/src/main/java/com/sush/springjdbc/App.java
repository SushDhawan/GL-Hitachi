package com.sush.springjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sush.springjdbc.dao.StudentJdbcTemplate;
import com.sush.springjdbc.model.Student;

public class App 
{
    public static void main( String[] args )
    {
        
    	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    	StudentJdbcTemplate studentJdbcTemplate = (StudentJdbcTemplate) context.getBean("jdbcTemplateObject");
    	    	
    	
		/* System.out.println("-----------Create  a Student Record -----------");
		 * studentJdbcTemplate.create("Raj", 19); studentJdbcTemplate.create("Mohit",
		 * 22); studentJdbcTemplate.create("Akash", 21);
		 */
    	
    	
    	System.out.println("-----List all record------");
    	
    	List<Student> students = studentJdbcTemplate.listStudent();
    	for(Student s : students) {
    		System.out.println(s);
    	}
    	System.out.println("-----Update record with id=4 ------");
    	
    	studentJdbcTemplate.update(23,4);
    	
    	System.out.println("------List record with id = 4  ----------");
    	System.out.println(studentJdbcTemplate.getStudent(4));
    
    	System.out.println("------Delete record with id = 6  ----------");
    	studentJdbcTemplate.delete(6);
    	
        students = studentJdbcTemplate.listStudent();
    	for(Student s : students) {
    		System.out.println(s);
    	}
    }
}
