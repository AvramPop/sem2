package com.example.adapter;

public interface Student {
  double computeSine();
  default double getHomework() {
    return 45;
  }
}
