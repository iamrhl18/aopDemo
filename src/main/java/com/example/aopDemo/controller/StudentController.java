package com.example.aopDemo.controller;

import com.example.aopDemo.dto.Student;
import com.example.aopDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/students")
public class StudentController{

    StudentService studentService;
    public  StudentController(StudentService studentService){
        System.out.println("controller injected the service object dependency");

        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) throws Throwable{
        System.out.println("controller create student called ");
        Student  s = studentService.createStudent(student);
        return ResponseEntity.ok(s);
    }

    @GetMapping
    public ResponseEntity<String> dummyMethod(){
        String s = "Student fetch sucessfully";
        return ResponseEntity.ok(studentService.getStudent(s));
    }
}
