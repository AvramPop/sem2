package com.example.service;

import com.example.dao.StudentRepository;
import com.example.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
  private StudentRepository studentRepository;

  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }

  @Autowired
  public void setStudentRepository(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }
}
