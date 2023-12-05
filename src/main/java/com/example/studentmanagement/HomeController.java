package com.example.studentmanagement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {
    private StudentService studentServ;

    public HomeController(StudentService studentServ) {
        this.studentServ = studentServ;
    }

    @GetMapping("/getStudents")
    //To get the list of students
    public List<Student> getStudents(){
        return studentServ.getStudents();
    }
    //To save the student in database
    @PostMapping("/addstudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        return new ResponseEntity<Student>(studentServ.saveStudent(student), HttpStatus.CREATED);
    }
    @GetMapping("/getstudentbyId/{id}")
    public Student getElementbyId(@PathVariable("id") long id){
        return studentServ.getStudentById(id);
    }
    @PutMapping("/updatestudent/{id}")
    public Student updateStudentById(Student student ,@PathVariable("id") long id){
        return studentServ.updateStudentbyId(student, id);
    }
    @DeleteMapping("/deleteStudentByid/{id}")
    public void deleteStudentById(@PathVariable("id") long id){
        studentServ.deleteStudentById(id);
    }
}
