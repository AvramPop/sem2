package com.example.facade;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.integration.SimpsonIntegrator;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;

public class IntegrationFacade {
  public double integratePolynomial(double[] coefficients, int inferiorBound, int superiorBound) {
    SimpsonIntegrator simpson = new SimpsonIntegrator();
    UnivariateFunction univariateFunction = new PolynomialFunction(coefficients);
    return simpson.integrate(10, univariateFunction, inferiorBound, superiorBound);
  }
}
