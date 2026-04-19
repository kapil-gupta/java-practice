package com.kapilspringjpa.demo;

import com.kapilspringjpa.demo.entity.Student;
import com.kapilspringjpa.demo.interfaces.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO){
		System.out.println("Started creating student");
		Student theStudent = new Student("Kapil","Gupta","kapil.gupta.softeng@gmail.com");

		studentDAO.save(theStudent);

		System.out.println("Student Created Id => "+theStudent.getId());

	}
}
