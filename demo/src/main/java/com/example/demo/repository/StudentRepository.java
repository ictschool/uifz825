package com.example.demo.repository;

import com.example.demo.model.Person;
import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Integer>, CrudRepository<Student,Integer> {

    Optional<Student> findById(Long id);

}
