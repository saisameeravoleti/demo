package com.example.demo.service.Impl;

import com.example.demo.entity.Students;
import com.example.demo.model.StudentsDTO;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    /*Creating an object for repo... Spring will find any "Autowired" annotation,
    it will create a reference of the object and it will insert into the variable */


    @Override
    public List<StudentsDTO> getStudentBy(int rollno, String section)
    {
        List<StudentsDTO> studentsDTOList=new ArrayList<>();

        // List<Students> list= new ArrayList<>(repo.userGetRepo(rollno, section));

        /*repo.findByRollnoAndSection(rollno, section).forEach(students -> { StudentsDTO studentDTO= new StudentsDTO();
            studentDTO.setDob(students.getDob());
            studentDTO.setRollno(students.getRollno());
            studentDTO.setSection(students.getSection());
            studentsDTOList.add(studentDTO);});*/

        for (Students s1: repo.findByRollnoAndSection(rollno, section)
             ) {
            StudentsDTO studentDTO= new StudentsDTO();
            studentDTO.setDob(s1.getDob());
            studentDTO.setRollno(s1.getRollno());
            studentDTO.setSection(s1.getSection());
            studentsDTOList.add(studentDTO);
        }
        return studentsDTOList;
    }

    @Override
    public List<Students> getAllStudents()
    {
        System.out.println("Hi");
        return repo.findAll();
    }

    @Override
    public Students getStudentByrollno(int rollno)
    {
        return repo.findById(rollno).orElse(null);
    }
}
