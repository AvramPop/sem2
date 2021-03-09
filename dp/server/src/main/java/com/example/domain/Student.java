package com.example.domain;

import javax.persistence.Column;
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
  private Integer group;

  public Student() {
  }

  public static class Builder {
    private String name;
    private Integer uniqueNumber, group, year;

    public Builder(Integer uniqueNumber) {
      this.uniqueNumber = uniqueNumber;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder year(Integer year) {
      this.year = year;
      return this;
    }

    public Builder group(Integer group) {
      this.group = group;
      return this;
    }

    public Student build() {
      Student student = new Student();
      student.uniqueNumber = this.uniqueNumber;
      student.name = this.name;
      student.year = this.year;
      student.group = this.group;
      return student;
    }
  }
}
