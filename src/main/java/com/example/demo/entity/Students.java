package com.example.demo.entity;

import javax.persistence.*;

@Entity(name="students")
@Table(name="students")
public class Students
{
    @Id
    @Column(name="rollno")
    private Integer rollno;

    @Column(name="section")
    private String section;

    @Column(name="dob")
    private String dob;

    public Integer getRollno() {
        return rollno;
    }

    public void setRollno(Integer rollno) {
        this.rollno = rollno;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}