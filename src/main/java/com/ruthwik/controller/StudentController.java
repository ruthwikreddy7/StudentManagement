package com.ruthwik.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruthwik.entity.Student;
import com.ruthwik.service.StudentService;

@RestController
@RequestMapping("/studapi")
public class StudentController {

    @Autowired
    private StudentService stdserv;

    @GetMapping("/students")
    public ResponseEntity<?> getAllStudents() {
        List<Student> students=stdserv.getall();
        if(students.isEmpty())
        {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No students present in database");
        }
        else
        {
        	return ResponseEntity.ok(students);
        }
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        Student std = stdserv.getByID(id); 
        return ResponseEntity.ok(std); 
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student std) {
        Student savedstd = stdserv.saveStudent(std);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedstd); 
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student newstd) {
        Student updatedStudent = stdserv.updateStudent(id, newstd);
        return ResponseEntity.ok(updatedStudent); 
    }
    
    
    @DeleteMapping("/delete/{id}")  
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id) {
        try {
            stdserv.deletestudent(id); 
            return ResponseEntity.ok().body(" Student with Roll no :"+id+" Deletd successfully"); 
        } catch (StudentService.StudentNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No student with Roll no : "+id+" Found to delete"); 
        } catch (Exception e) { 
            return ResponseEntity.internalServerError().build(); 
        }
    }
}