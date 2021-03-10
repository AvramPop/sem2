package com.example.ui;

import com.example.service.GradeService;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Console {
  private GradeService gradeService;
  private StudentService studentService;

  public void run() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      printMenu();
      int input = scanner.nextInt();
      switch(input) {
        case 1:
          printStudents();
          break;
        case 2:
          printGrades();
          break;
        case 3:
          addFullStudent();
          break;
        case 4:
          addTemporaryStudent();
          break;
        case 5:
          addGrade();
          break;
        case 6:
          exportToXML();
          break;
        case 7:
          exportToPlainText();
          break;
        case 0:
          System.out.println("Bye");
          return;
        default:
          System.out.println("Bad input");
          break;
      }
    }
  }

  private void exportToPlainText() {
    gradeService.persistGradesToPlainText();
  }

  private void exportToXML() {
    gradeService.persistGradesToXml();
  }

  private void addGrade() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("student unique number:");
    int uniqueNumber = Integer.parseInt(scanner.nextLine());
    System.out.println("subject");
    String subject = scanner.nextLine();
    System.out.println("value");
    int value = Integer.parseInt(scanner.nextLine());
    gradeService.addGrade(subject, value, uniqueNumber);

  }

  private void addTemporaryStudent() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("unique number:");
    int uniqueNumber = Integer.parseInt(scanner.nextLine());
    System.out.println("name");
    String name = scanner.nextLine();
    studentService.addTemporaryStudent(uniqueNumber, name);
  }

  private void addFullStudent() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("unique number:");
    int uniqueNumber = Integer.parseInt(scanner.nextLine());
    System.out.println("name");
    String name = scanner.nextLine();
    System.out.println("year");
    int year = Integer.parseInt(scanner.nextLine());
    System.out.println("team");
    int team = Integer.parseInt(scanner.nextLine());
    studentService.addFullStudent(uniqueNumber, name, year, team);
  }

  private void printMenu() {
    System.out.println("1 - list students");
    System.out.println("2 - list grades");
    System.out.println("3 - add full student");
    System.out.println("4 - add erasmus student");
    System.out.println("5 - add grade");
    System.out.println("6 - export to XML");
    System.out.println("7 - export to plain text file");
    System.out.println("0 - exit");
    System.out.print(">");
  }

  private void printStudents() {
    studentService.getAllStudents().forEach(s -> System.out.println(s.toString()));
  }

  private void printGrades() {
    gradeService.getAllGrades().forEach(g -> System.out.println(g.toString()));
  }

  @Autowired
  public void setGradeService(GradeService gradeService) {
    this.gradeService = gradeService;
  }

  @Autowired
  public void setStudentService(StudentService studentService) {
    this.studentService = studentService;
  }
}
