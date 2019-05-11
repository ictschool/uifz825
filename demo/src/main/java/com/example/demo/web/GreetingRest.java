package com.example.demo.web;

import com.example.demo.model.Greeting;
import com.example.demo.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class GreetingRest {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greeting")
    public List<Greeting> getGreeting(){
        return greetingService.getGreetings();
    }

    @GetMapping(value = "/greeting", params = {"id"})
    public Greeting getGreetingById(@RequestParam("id") Integer id){
        return greetingService.getById(id);
    }

    @DeleteMapping(value = "/greeting", params = {"id"})
    public void deleteGreeting(@RequestParam("id") Integer id){
        greetingService.deleteGreeting(id);
    }

    @PostMapping("/greeting")
    public void saveGreeting(@RequestBody Greeting greeting){
        greetingService.saveGreeting(greeting);
    }

}
