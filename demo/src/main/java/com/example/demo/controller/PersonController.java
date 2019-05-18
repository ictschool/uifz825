package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    /**
     * wird ein Formular via Post abgesendet, greift diese Methode
     * um den Bezug zu den versendeten Daten des Formulares herzustellen muss
     * @ModelAttribute als Annotation verwendet werden
     * @Valid prüft die Gültigkeit der Daten im Person Objekt
     * @Model stellt das Binding zur Template Datei her
     */
    public String add(@ModelAttribute @Valid Person person, Model model){
        personService.addPerson(person);
        model.addAttribute("saved", true);
        model.addAttribute(person);
        return "personForm";
    }

    @GetMapping(value = {"", "/{id}"})
    public String showForm(@PathVariable("id") Optional<Long> id, Model model){
        Person person;
        if(id.isPresent())
            person = personService.getPerson(id.get());
        else
            person = new Person();

        model.addAttribute("saved", false);
        model.addAttribute("person", person);
        return "personForm";
    }


}
