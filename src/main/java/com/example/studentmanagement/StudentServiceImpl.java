package com.example.studentmanagement;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student getStudentById(long id) {
        Optional<Student> student = studentRepo.findById(id);
        if(student.isPresent()) return student.get();
        else throw new RuntimeException();
    }

}
