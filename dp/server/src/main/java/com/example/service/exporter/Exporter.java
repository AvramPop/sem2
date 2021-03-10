package com.example.service.exporter;

import com.example.domain.Grade;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public abstract class Exporter {
  protected String filename;

  public Exporter() {}

  public void exportGrades(List<Grade> grades, String filename) {
    String filePath = generateFilePath(filename);
    String dataAsPlainString = convertGradesToString(grades);
    try {
      writeDataToFile(dataAsPlainString, filePath);
    } catch(IOException e) {
      System.err.println(e.getClass().getSimpleName());
    }
  }

  protected abstract String convertGradesToString(List<Grade> grades);

  protected abstract String generateFilePath(String filename);

  private void writeDataToFile(String dataAsPlainString, String filePath) throws IOException {
    Files.write(Paths.get(filePath), dataAsPlainString.getBytes());
  }
}
