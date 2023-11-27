package com.example.studentmanagement;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    Student saveStudent(Student student);
}
