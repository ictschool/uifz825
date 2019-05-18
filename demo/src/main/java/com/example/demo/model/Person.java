package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_person")
    @SequenceGenerator(name = "seq_person", allocationSize = 10)
    private Long id;
    @NotEmpty
    @NotNull
    private String name;
    @NotEmpty
    @NotNull
    private String firstname;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "addressFk")
    private Address address;

    public Person(String name, String firstname) {
        this.name = name;
        this.firstname = firstname;
        this.address = new Address();
    }

    public Person() {
        this.address = new Address();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
