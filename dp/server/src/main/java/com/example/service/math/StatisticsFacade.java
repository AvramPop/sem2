package com.example.service.math;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

public class StatisticsFacade {
  public static Map.Entry<Double, Double> getMeanAndStandardDeviation(List<Double> inputBuffer) {
    DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();
    inputBuffer.forEach(descriptiveStatistics::addValue);
    return new AbstractMap.SimpleEntry<>(
        descriptiveStatistics.getMean(), descriptiveStatistics.getStandardDeviation());
  }
}
