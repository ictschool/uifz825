package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_greeting")
    @SequenceGenerator(name = "seq_greeting", allocationSize = 10, initialValue = 100)
    private Integer id;

    @NotNull
    @NotEmpty
    @Size(min = 4)
    private String name;

    public Greeting(){

    }

    public Greeting(String name){
        this.name = name;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
