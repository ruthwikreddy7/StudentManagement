package com.ruthwik.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruthwik.entity.Student;
import com.ruthwik.repository.StudentRepository;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepository studrepo;

    public List<Student> getall() {
        return studrepo.findAll();
    }

    public Student updateStudent(Integer id, Student newstd) {
    	Student existingStudent = getByID(id); 

        
        if (newstd.getName() != null) {
            existingStudent.setName(newstd.getName());
        }
        if (newstd.getClassnumber() != null) {
            existingStudent.setClassnumber(newstd.getClassnumber());
        }
        if (newstd.getSection() != null) {
            existingStudent.setSection(newstd.getSection());
        }
        if (newstd.getPercentage() != null) {
            existingStudent.setPercentage(newstd.getPercentage());
        }

        return studrepo.save(existingStudent);
    
    }

    public Student saveStudent(Student stu) {
        return studrepo.save(stu);
    }

    public void deletestudent(Integer id) {
        Student student = getByID(id); 
        studrepo.delete(student);
        
    }

    public Student getByID(Integer id) {
        return studrepo.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with Roll No: " + id + " not found in records"));
    }

    public class StudentNotFoundException extends RuntimeException {
        public StudentNotFoundException(String message) {
            super(message);
        }
    }
}