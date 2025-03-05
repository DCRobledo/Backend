package com.drobledo.cruddemo;

import com.drobledo.cruddemo.dao.StudentDAO;
import com.drobledo.cruddemo.dao.StudentDAOImpl;
import com.drobledo.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			ReadAllStudents(studentDAO);
		};
	}

	private void ReadAllStudents(StudentDAO studentDAO) {
		List<Student> studentsList = studentDAO.findAll();
		for (Student student : studentsList)
		{
			System.out.println(student.toString());
		}
	}

	private void ReadStudent(StudentDAO studentDAO, Integer id) {
		Student targetStudent = studentDAO.findById(id);
		System.out.println(targetStudent.toString());
	}

	private void CreateStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student newStudent = new Student("Jake", "Sr", "jakethedog@gmail.com");

		System.out.println("Saving the student...");
		studentDAO.save(newStudent);

		System.out.println("Saved student. Generated id: " + newStudent.getId());
	}
}
