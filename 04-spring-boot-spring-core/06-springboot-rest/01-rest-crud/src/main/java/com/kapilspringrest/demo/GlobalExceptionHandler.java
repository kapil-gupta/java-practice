package com.kapilspringrest.demo;

import com.kapilspringrest.demo.exceptions.StudentNotFoundException;
import com.kapilspringrest.demo.responses.StudentErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

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
}
