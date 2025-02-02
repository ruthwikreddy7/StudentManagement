package com.ruthwik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruthwik.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
