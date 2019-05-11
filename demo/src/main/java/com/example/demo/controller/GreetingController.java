package com.example.demo.controller;

import com.example.demo.model.Greeting;
import com.example.demo.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        greetingService.saveGreeting(new Greeting(name));
        model.addAttribute("greetings", greetingService.getGreetings());
        return "test/greeting";
    }

    @GetMapping(value = "/delete", params = {"id"})
    public String delete(@RequestParam(name="id") Integer id, Model model) {
        greetingService.deleteGreeting(id);
        model.addAttribute("greetings", greetingService.getGreetings());
        return "test/greeting";
    }

}