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

  public void addFullStudent(Integer uniqueNumber, String name, Integer year, Integer team) {
    Student student = new Student.StudentBuilder(uniqueNumber).name(name).year(year).team(team).build();
    studentRepository.save(student);
  }

  @Autowired
  public void setStudentRepository(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public void addTemporaryStudent(int uniqueNumber, String name) {
    Student student = new Student.StudentBuilder(uniqueNumber).name(name).build();
    studentRepository.save(student);

  }
}
