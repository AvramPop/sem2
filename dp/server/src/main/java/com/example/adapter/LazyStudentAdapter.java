package com.example.adapter;

import org.apache.commons.math3.util.FastMath;

public class LazyStudentAdapter implements Student {
  private LazyStudent lazyStudent;

  public LazyStudentAdapter(LazyStudent lazyStudent) {
    this.lazyStudent = lazyStudent;
  }

  @Override
  public double computeSine() {
    double radians = degreesToRadians(lazyStudent.getHomework());
    return FastMath.sin(radians);
  }

  private double degreesToRadians(double degrees) {
    return FastMath.toRadians(degrees);
  }
}
