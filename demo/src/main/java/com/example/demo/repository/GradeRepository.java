package com.example.demo.repository;

import com.example.demo.model.Grade;
import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GradeRepository extends JpaRepository<Grade,Long>, CrudRepository<Grade,Long> {



}
