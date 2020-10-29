package edu.cinfantes.fibonacci.domain.service;

import edu.cinfantes.fibonacci.domain.exception.FibonacciTermMustBePositive;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FibonacciBinetFormulaTest {
  private FibonacciCalculator fibonacciCalculator;
  
  @BeforeEach
  void setUp() {
    fibonacciCalculator = new FibonacciBinetFormula();
  }
  
  @Test
  void should_throw_exception_when_element_lower_than_zero() {
    Assertions.assertThrows(FibonacciTermMustBePositive.class,
      () -> fibonacciCalculator.calculateNthTerm(-1));
  }
  
  @Test
  void should_return_zero_when_element_is_zero() {
    long element = fibonacciCalculator.calculateNthTerm(0);
    assertThat(element).isEqualTo(0);
  }
  
  @Test
  void should_return_one_when_element_is_one() {
    long element = fibonacciCalculator.calculateNthTerm(1);
    assertThat(element).isEqualTo(1);
  }
  
  @Test
  void should_return_nth_element_when_element_is_greater_than_one() {
    long element = fibonacciCalculator.calculateNthTerm(22);
    assertThat(element).isEqualTo(17711);
  }
}