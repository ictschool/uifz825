package com.example.demo.service;

import com.example.demo.model.Greeting;
import com.example.demo.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    public void saveGreeting(Greeting greeting){
        if(!greeting.getName().equals("World")){
            greetingRepository.saveAndFlush(greeting);
        }
    }

    public Greeting getById(Integer id){
        Optional<Greeting> optionalGreeting = greetingRepository.findById(id);
        if(optionalGreeting.isPresent()){
            return optionalGreeting.get();
        }
        return null;
    }

    public void deleteGreeting(Integer id){
        Greeting greeting = getById(id);
        greetingRepository.delete(greeting);
    }

    public List<Greeting> getGreetings(){
        return greetingRepository.findAll();
    }

}
