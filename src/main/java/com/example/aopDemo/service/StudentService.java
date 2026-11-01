package com.example.aopDemo.service;

import com.example.aopDemo.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public Student saveStudent(Student student){

        System.out.println("Student saved");
        //throw new RuntimeException("Some Errorr occured ");
        return student;
    }

    public String dummy(String s){

        System.out.println("Dummy called ");
        return s;
    }
}
