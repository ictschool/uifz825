package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.model.Student;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository personRepository;

    public Long addPerson(@Valid Student person){

        person = personRepository.saveAndFlush(person);

        return person.getId();
    }

    public Student getPerson(Long id){
        Student person = new Student();
        if(id != null){
            Optional<Student> optionalPerson = personRepository.findById(id);
            if(optionalPerson.isPresent())
                person = optionalPerson.get();
        }
        return person;
    }

}
