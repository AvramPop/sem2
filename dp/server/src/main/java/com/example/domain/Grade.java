package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.awt.print.Book;
import java.util.List;

@Entity
@Table(name="grades")
public class Grade {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String subject;
  private Integer value;
  private Integer studentId;

  public Grade() { }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  public Integer getStudentId() {
    return studentId;
  }

  public void setStudentId(Integer studentId) {
    this.studentId = studentId;
  }

  public Grade(String subject, Integer value, Integer studentId) {
    this.subject = subject;
    this.value = value;
    this.studentId = studentId;
  }

  @Override
  public String toString() {
    return "Grade{" +
        "id=" + id +
        ", subject='" + subject + '\'' +
        ", value=" + value +
        ", studentId=" + studentId +
        '}';
  }
}
