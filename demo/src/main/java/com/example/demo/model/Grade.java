package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_grade")
    @SequenceGenerator(name = "seq_grade", allocationSize = 10)
    private Long id;

    @NotNull
    @NotEmpty
    private String module;

    @Min(1)
    @NotNull
    private float value;

    public Grade() {
    }

    public Grade(Student student, @NotNull @NotEmpty String module, @Min(1) @NotNull float value) {
        this.module = module;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
