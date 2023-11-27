package com.example.studentmanagement;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService{
    private StudentRepository studentRepo;

    public StudentServiceImpl(StudentRepository studentRepo) {
        super();
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepo.findAll().stream().toList();
    }

}
