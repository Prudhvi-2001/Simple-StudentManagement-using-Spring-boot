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

    @Override
    public Student updateStudentbyId(Student student, long id) {
        Student existingStudent = studentRepo.findById(id).get();
        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        studentRepo.save(existingStudent);
        return  existingStudent;
    }

    @Override
    public void deleteStudentById(long id) {
      studentRepo.deleteById(id);
    }

}
