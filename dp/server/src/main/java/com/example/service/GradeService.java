package com.example.service;

import com.example.dao.GradeRepository;
import com.example.domain.Grade;
import com.example.service.exporter.Exporter;
import com.example.service.exporter.PlainTextExporter;
import com.example.service.exporter.XmlExporter;
import com.example.service.math.StatisticsFacade;
import com.example.service.sorting.SortByNumber;
import com.example.service.sorting.SortBySubject;
import com.example.service.sorting.SortByValue;
import com.example.service.sorting.SortStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GradeService {
  private GradeRepository gradeRepository;

  public List<Grade> getAllGrades() {
    return gradeRepository.findAll();
  }

  public void addGrade(String subject, Integer value, Integer studentId) {
    Grade grade = new Grade(subject, value, studentId);
    gradeRepository.save(grade);
  }

  public void persistGradesToXml() {
    Exporter xmlExporter = new XmlExporter();
    String uniqueFilename = "grades" + LocalDateTime.now().toString();
    xmlExporter.exportGrades(gradeRepository.findAll(), uniqueFilename);
  }

  public void persistGradesToPlainText() {
    Exporter plainTextExporter = new PlainTextExporter();
    String uniqueFilename = "grades" + LocalDateTime.now().toString();
    plainTextExporter.exportGrades(gradeRepository.findAll(), uniqueFilename);
  }

  @Autowired
  public void setGradeRepository(GradeRepository gradeRepository) {
    this.gradeRepository = gradeRepository;
  }

  public Map.Entry<Double, Double> getMeanAndStandardDeviation() {
    return StatisticsFacade.getMeanAndStandardDeviation(
        gradeRepository.findAll().stream()
            .map(g -> g.getValue().doubleValue())
            .collect(Collectors.toList()));
  }

  public List<Grade> sortedGrades(int option) {
    SortStrategy sortStrategy;
    if (option == 1) {
      sortStrategy = new SortByNumber();
    } else if (option == 2) {
      sortStrategy = new SortByValue();
    } else {
      sortStrategy = new SortBySubject();
    }
    return sortStrategy.sorted(gradeRepository.findAll());
  }
}
