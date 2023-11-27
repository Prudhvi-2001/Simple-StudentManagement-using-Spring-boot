package com.example.studentmanagement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    private StudentService studentServ;
    @GetMapping("/getStudents")
    public List<Student> getStudents(){
        return studentServ.getStudents();
    }
}
