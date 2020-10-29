package edu.cinfantes.fibonacci.domain.service;

import edu.cinfantes.fibonacci.domain.exception.FibonacciTermMustBePositive;
import org.springframework.stereotype.Component;

@Component
public class FibonacciBinetFormula implements FibonacciCalculator{
  
  public long calculateNthTerm(long element) {
    ensureElementIsPositive(element);
    
    double squareRootOf5 = Math.sqrt(5);
    double phi = (1 + squareRootOf5)/2;
    return (long) ((Math.pow(phi, element) - Math.pow(-phi, -element))/squareRootOf5);
  }
  
  private void ensureElementIsPositive(long element) {
    if (element < 0L) {
      throw new FibonacciTermMustBePositive();
    }
  }
}
