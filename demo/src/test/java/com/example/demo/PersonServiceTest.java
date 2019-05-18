package com.example.demo;

import com.example.demo.model.Address;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PersonServiceTest {

    @Autowired
    PersonService personService;

    @MockBean
    PersonRepository personRepository;

    Person correctPerson;

    @Before
    public void before(){
        correctPerson = new Person();
        correctPerson.setId(new Long(1));
    }

    @Test
    public void addPerson(){
        Person person = new Person("Buchs", "Enrico");
        person.setAddress(new Address("Buchenweg 5", "2552", "Orpund"));

        Mockito.when(personRepository.saveAndFlush(person)).thenReturn(correctPerson);

        assertNotNull(personService.addPerson(person));
    }


    @Test
    public void addPersonFailure(){
        try {
            Person person = new Person("Buchs", "Enrico");
            person.setAddress(new Address("", "2552", "Orpund"));

            Mockito.when(personRepository.saveAndFlush(person)).thenReturn(person);

            assertNull(personService.addPerson(person));
        }catch (Exception e){
            assertNotNull(e.getMessage());
        }
    }

}
