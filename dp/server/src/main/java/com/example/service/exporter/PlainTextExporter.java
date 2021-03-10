package com.example.service.exporter;

import com.example.domain.Grade;

import java.util.List;

public class PlainTextExporter extends Exporter {
  @Override
  protected String convertGradesToString(List<Grade> grades) {
    StringBuilder stringBuilder = new StringBuilder();
    grades.forEach(
        grade ->
            stringBuilder
                .append(grade.getStudentId().toString())
                .append(" ")
                .append(grade.getSubject())
                .append(" ")
                .append(grade.getValue().toString())
                .append("\n"));
    return stringBuilder.toString();
  }

  @Override
  protected String generateFilePath(String filename) {
    return "/home/dani/Desktop/code/scoala/an3/sem2/dp/server/src/main/resources/"
        + filename
        + ".txt";
  }
}
