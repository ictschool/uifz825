package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Long addPerson(@Valid Person person){

        person = personRepository.saveAndFlush(person);

        return person.getId();
    }

    public Person getPerson(Long id){
        Person person = new Person();
        if(id != null){
            Optional<Person> optionalPerson = personRepository.findById(id);
            if(optionalPerson.isPresent())
                person = optionalPerson.get();
        }
        return person;
    }

}
