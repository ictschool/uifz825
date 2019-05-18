package com.example.demo.repository;

import com.example.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person,Integer>, CrudRepository<Person,Integer> {

    Optional<Person> findById(Long id);

}
