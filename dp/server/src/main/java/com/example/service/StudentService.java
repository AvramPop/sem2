package com.example.service;

import com.example.dao.StudentRepository;
import com.example.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

  @Transactional
  public void updateStudentYear(int uniqueNumber, int newYear) {
    Student studentProxy = studentRepository.getOne(uniqueNumber);
    System.out.println(studentProxy.getYear());
    studentProxy.setYear(newYear);
    studentRepository.save(studentProxy);
  }
}
