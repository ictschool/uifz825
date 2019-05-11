package com.example.demo.repository;

import com.example.demo.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GreetingRepository extends JpaRepository<Greeting,Integer>, CrudRepository<Greeting,Integer> {

    Optional<Greeting> findById(Integer id);

}
