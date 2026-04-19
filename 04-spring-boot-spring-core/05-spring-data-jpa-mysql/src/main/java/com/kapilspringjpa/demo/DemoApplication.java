package com.kapilspringjpa.demo;

import com.kapilspringjpa.demo.entity.Student;
import com.kapilspringjpa.demo.interfaces.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			// createStudent(studentDAO);
			// listAllStudents(studentDAO);
			// listAllStudentsByFirstName(studentDAO);
			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			deleteAllStudent(studentDAO);
			


		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		studentDAO.deleteAll();
		System.out.println("All Student deleted");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int id = 2;
		System.out.println("First Retrieve the Student with Id => "+id);

		Student s  = studentDAO.findById(id);
		System.out.println("Student Current Data ");
		System.out.println(s);


		studentDAO.delete(2);

		System.out.println("Student deleted ");
	}

	private void updateStudent(StudentDAO studentDAO) {
		int id = 1;
		System.out.println("First Retrieve the Student with Id => "+id);

		Student s  = studentDAO.findById(id);
		System.out.println("Student Current Data ");
		System.out.println(s);

		// Updating the Object
		s.setEmail("abc@gmail.com");
		s.setFirstName("AAA");
		s.setLastName("BBB");

		// Now Update the object in DB
		studentDAO.update(s);

		System.out.println("Student Updated Data ");
		System.out.println(s);

	}

	private void listAllStudentsByFirstName(StudentDAO studentDAO) {
		List<Student> allStudents  = studentDAO.findAllByFirstName("kapil");

		for(Student s: allStudents)
			System.out.println(s);
	}

	private void listAllStudents(StudentDAO studentDAO) {
		List<Student> allStudents  = studentDAO.findAll();

		for(Student s: allStudents)
			System.out.println(s);
	}

	private void createStudent(StudentDAO studentDAO){
		System.out.println("Started creating student");
		Student theStudent1 = new Student("Kapil","Gupta","kapil.gupta.softeng@gmail.com");
		Student theStudent2 = new Student("Ashish","Gupta","Ashish.gupta.softeng@gmail.com");
		Student theStudent3 = new Student("Rahul","Gupta","Rahul.gupta.softeng@gmail.com");
		Student theStudent4 = new Student("Manish","Gupta","Manish.gupta.softeng@gmail.com");
		Student theStudent5 = new Student("Akshay","Gupta","Akshay.gupta.softeng@gmail.com");

		studentDAO.save(theStudent1);
		studentDAO.save(theStudent2);
		studentDAO.save(theStudent3);
		studentDAO.save(theStudent4);
		studentDAO.save(theStudent5);

		System.out.println("Student 1 Created Id => "+theStudent1.getId());
		System.out.println("Student 2 Created Id => "+theStudent2.getId());
		System.out.println("Student 3 Created Id => "+theStudent3.getId());
		System.out.println("Student 4 Created Id => "+theStudent4.getId());
		System.out.println("Student 5 Created Id => "+theStudent5.getId());


		// Now Read the Student

		Student someStudent =studentDAO.findById(3);
		// toString method will be used to print the student data
		System.out.println("Selected Student Data =>  " +someStudent);

	}
}
