package com.example.demo.controller;

import com.example.demo.entity.Students;
import com.example.demo.model.StudentsDTO;
import com.example.demo.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/users/getStudentbyRoll")
    public List<StudentsDTO> getStudentbyRollno(@RequestParam int rollno, @RequestParam String section)
    {
        /*if(StringUtils.isNotBlank(section))
        {
            return new Exception();
        }*/

        if(StringUtils.isBlank(String.valueOf(rollno)))
        {
            throw new IllegalArgumentException("rollno should not be blank");
        }
        if(StringUtils.isBlank(section))
        {
            throw new IllegalArgumentException("section should not be blank");
        }
        return service.getStudentBy(rollno, section);


    }

    @GetMapping("/allstudents")
    public ResponseEntity<List<Students>> getAllStudents() {
        List<Students> students=new ArrayList<>();
        try
        {
            System.out.println("Hello");
            students=service.getAllStudents();
            System.out.println("Working");
        }
        catch (Exception e){
            e.getMessage();
        }
        return new ResponseEntity<List<Students>>(students,HttpStatus.OK);
        //or return new ResponseEntity<>(service.getAllStudents(),HttpStatus.OK);
    }

    @GetMapping("/fingById/{rollno}")
    public ResponseEntity<Students> getfindByRollNo(@PathVariable("rollno") int rollno) {
        Students students = null;
        try {
            students = service.getStudentByrollno(rollno);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return new ResponseEntity<Students>(students, HttpStatus.OK);
    }
}
