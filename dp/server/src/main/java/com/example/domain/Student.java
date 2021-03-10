package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
  @Id
  private Integer uniqueNumber;

  private String name;
  private Integer year;
  private Integer team;

  public Student() {
  }

  @Override
  public String toString() {
    return "Student{" +
        "uniqueNumber=" + uniqueNumber +
        ", name='" + name + '\'' +
        ", year=" + year +
        ", team=" + team +
        '}';
  }

  public void setYear(int year) {
    this.year = year;
  }

  public Integer getYear() {
    return year;
  }

  public static class StudentBuilder {
    private String name;
    private Integer uniqueNumber, team, year;

    public StudentBuilder(Integer uniqueNumber) {
      this.uniqueNumber = uniqueNumber;
    }

    public StudentBuilder name(String name) {
      this.name = name;
      return this;
    }

    public StudentBuilder year(Integer year) {
      this.year = year;
      return this;
    }

    public StudentBuilder team(Integer team) {
      this.team = team;
      return this;
    }

    public Student build() {
      Student student = new Student();
      student.uniqueNumber = this.uniqueNumber;
      student.name = this.name;
      student.year = this.year;
      student.team = this.team;
      return student;
    }
  }
}
