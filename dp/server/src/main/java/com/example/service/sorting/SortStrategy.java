package com.example.service.sorting;

import com.example.domain.Grade;

import java.util.List;

public interface SortStrategy {
  List<Grade> sorted(List<Grade> grades);
}
