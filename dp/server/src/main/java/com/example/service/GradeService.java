package com.example.service;

import com.example.dao.GradeRepository;
import com.example.domain.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
  private GradeRepository gradeRepository;

  public List<Grade> getAllGrades() {
    return gradeRepository.findAll();
  }

  @Autowired
  public void setGradeRepository(GradeRepository gradeRepository) {
    this.gradeRepository = gradeRepository;
  }
}
