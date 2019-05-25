package com.example.demo;

import com.example.demo.model.Address;
import com.example.demo.model.City;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest
@ActiveProfiles("test")
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void personSaveTest(){
        Person person = new Person("Buchs", "Enrico");
        Address address = new Address("Buchenweg 5", new City("2552", "Orpund"));
        person.setAddress(address);

        personRepository.saveAndFlush(person);

        assertNotNull(person.getId());
    }

    @Test
    public void personSaveFailureTest(){
        try{
            Person person = new Person("", "Enrico");
            Address address = new Address("Buchenweg 5", new City("2552", "Orpund"));
            person.setAddress(address);

            personRepository.saveAndFlush(person);

            assertNull(person.getId());
        }catch (Exception e){

        }
    }



}
