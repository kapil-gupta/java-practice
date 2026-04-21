package com.kapilspringrest.demo;

import com.kapilspringrest.demo.entity.Student;
import com.kapilspringrest.demo.exceptions.StudentNotFoundException;
import com.kapilspringrest.demo.responses.StudentErrorResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRestController {

    private List<Student> theStudents;

    @PostConstruct
    public void initializeData(){
        theStudents = new ArrayList<>();

        Student s1 = new Student("kapil", "Gupta");
        Student s2 = new Student("aaaa", "aaaa");
        Student s3 = new Student("bbbb", "bbbb");
        Student s4 = new Student("cccc", "ccc");
        theStudents.add(s1);
        theStudents.add(s2);
        theStudents.add(s3);
        theStudents.add(s4);
    }

    @GetMapping("/students")
    public List<Student> listAllStudents(){
        return theStudents;
    }
    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        if(studentId<0 || studentId>theStudents.size()){
            throw new StudentNotFoundException("Student with Id "+studentId+ " not found");
        }
        return theStudents.get(studentId);
    }

    /*
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
        StudentErrorResponse res = new StudentErrorResponse(
                HttpStatus.NOT_FOUND.value(),exc.getMessage(),System.currentTimeMillis()
        );

        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
        StudentErrorResponse res = new StudentErrorResponse();
        res.setMessage(exc.getMessage());
        res.setStatus(HttpStatus.BAD_REQUEST.value());
        res.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);

    }
    */

}
