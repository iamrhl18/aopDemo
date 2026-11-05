package com.example.aopDemo.service;

import com.example.aopDemo.annotation.MeasureExecutionTime;
import com.example.aopDemo.dto.Student;
import jdk.jfr.Timespan;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @MeasureExecutionTime(warnAfter = 2000 , operation = "Creating student")
    public Student createStudent(Student student) throws Throwable{
        System.out.println("Student saved");
        try {
            Thread.sleep(2000);
        }catch (Exception e){

        }
        return student;
    }

    @MeasureExecutionTime(warnAfter = 1 , operation = "Getting student")
    public String getStudent(String s){
        System.out.println(s);
        return s;
    }


}
