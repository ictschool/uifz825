package com.example.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student extends Person {

    @Column(unique = true)
    private String matNumber;
    @OneToMany(cascade = {CascadeType.ALL},
            orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "studentFk")
    private List<Grade> gradeList = new ArrayList<>();

    public Student(){
        super();
    }

    public Student(String name, String firstname, String matNumber) {
        super(name, firstname);
        this.matNumber = matNumber;
    }

    public String getMatNumber() {
        return matNumber;
    }

    public void setMatNumber(String matNumber) {
        this.matNumber = matNumber;
    }

    public List<Grade> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<Grade> gradeList) {
        this.gradeList = gradeList;
    }

}
