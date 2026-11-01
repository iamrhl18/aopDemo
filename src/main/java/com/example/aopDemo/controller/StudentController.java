package com.example.aopDemo.controller;

import com.example.aopDemo.dto.Student;
import com.example.aopDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/students")
public class StudentController {
    StudentService studentService;
    public  StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student  s = studentService.saveStudent(student);
        return ResponseEntity.ok(s);
    }

    @GetMapping
    public ResponseEntity<String> dummyMethod(){
        String s = "Rahul ";
        return ResponseEntity.ok(studentService.dummy(s));
    }
}
