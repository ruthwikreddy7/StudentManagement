package com.ruthwik.controller; 

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ruthwik.service.StudentService; 

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StudentService.StudentNotFoundException.class)
    public ResponseEntity<String> handleStudentNotFound(StudentService.StudentNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        
        System.err.println("An error occurred: " + ex.getMessage()); 
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred."); 
    }
}