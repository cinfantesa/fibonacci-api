package edu.cinfantes.fibonacci.infrastructure.rest;

import edu.cinfantes.fibonacci.domain.service.FibonacciCalculator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;

import static org.springframework.http.ResponseEntity.ok;

@Validated
@RestController
@AllArgsConstructor
public class FibonacciController {
  private final FibonacciCalculator fibonacciCalculator;
  
  @GetMapping(path = "/api/fibonacci/{element}")
  public ResponseEntity<Long> calculate(@PathVariable("element") @Min(0) long element) {
    return ok(fibonacciCalculator.calculateNthTerm(element));
  }
}
