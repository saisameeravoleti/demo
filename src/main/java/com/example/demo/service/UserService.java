package com.example.demo.service;

import com.example.demo.entity.Students;
import com.example.demo.model.StudentsDTO;

import java.util.List;

public interface UserService {

    /*4 methods:
    1) Find all the users present;
    2) Find user by ID;
    3) Update or add users;
    4) Delete users*/

    public List<Students> getAllStudents();

    public Students getStudentByrollno(int rollno);

    public List<StudentsDTO> getStudentBy(int rollno, String section);

}
