package com.example.service.sorting;

import com.example.domain.Grade;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortBySubject implements SortStrategy{
  @Override
  public List<Grade> sorted(List<Grade> grades) {
    return grades.stream().sorted(Comparator.comparing(Grade::getSubject)).collect(Collectors.toList());
  }
}
