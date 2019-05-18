package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "address")
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_address")
    @SequenceGenerator(name = "seq_address", allocationSize = 10)
    private Long id;
    @NotEmpty
    @NotNull
    private String street;
    @NotNull
    @NotEmpty
    @Size(max = 4)
    private String zip;
    @NotNull
    @NotEmpty
    private String city;

    public Address() {
    }

    public Address(String street, String zip, String city) {
        this.street = street;
        this.zip = zip;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
