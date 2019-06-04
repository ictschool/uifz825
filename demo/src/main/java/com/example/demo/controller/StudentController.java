package com.example.demo.controller;

import com.example.demo.model.Grade;
import com.example.demo.model.Person;
import com.example.demo.model.Student;
import com.example.demo.repository.GradeRepository;
import com.example.demo.service.PersonService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private GradeRepository gradeRepository;

    @PostMapping
    /**
     * wird ein Formular via Post abgesendet, greift diese Methode
     * um den Bezug zu den versendeten Daten des Formulares herzustellen muss
     * @ModelAttribute als Annotation verwendet werden
     * @Valid prüft die Gültigkeit der Daten im Person Objekt
     * @Model stellt das Binding zur Template Datei her
     */
    public String add(@ModelAttribute @Valid Student student, @ModelAttribute Grade grade, Model model){
        System.out.println("Anzahl Grades: "+student.getGradeList().size());
        if(grade.getModule().length() >= 1)
            student.getGradeList().add(grade);
        studentService.addPerson(student);
        model.addAttribute("saved", true);
        Optional<Long> optional = Optional.of(student.getId());
        return showForm(optional, model);
    }

    @GetMapping(value = {"", "/{id}"})
    public String showForm(@PathVariable("id") Optional<Long> id, Model model){
        Student student;
        if(id.isPresent())
            student = studentService.getPerson(id.get());
        else
            student = new Student();

        model.addAttribute("saved", false);
        model.addAttribute("student", student);
        model.addAttribute("grade", new Grade());
        return "studentForm";
    }

    @PostMapping(value = "deleteGrade", params = {"id"})
    @ResponseBody
    public String deleteGrade(@RequestParam("id") Long id){
        Optional<Grade> gradeOptional = gradeRepository.findById(id);
        if(gradeOptional.isPresent())
            gradeRepository.delete(gradeOptional.get());
        System.out.println("DELETE");
        return "DELETED: " + id;
    }



}
