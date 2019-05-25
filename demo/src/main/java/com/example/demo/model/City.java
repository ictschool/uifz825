package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_city")
    @SequenceGenerator(name = "seq_city", allocationSize = 10)
    private Long id;

    @NotNull
    @NotEmpty
    @Size(max = 4)
    private String zip;
    @NotNull
    @NotEmpty
    private String name;

    public City() {
    }

    public City(@NotNull @NotEmpty @Size(max = 4) String zip, @NotNull @NotEmpty String name) {
        this.zip = zip;
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public void setName(String city) {
        this.name = city;
    }
}
