package edu.cinfantes.fibonacci.infrastructure.rest;

import edu.cinfantes.fibonacci.domain.service.FibonacciCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FibonacciController.class)
class FibonacciControllerTest {
  @MockBean
  private FibonacciCalculator fibonacciCalculator;
  
  @Autowired
  private MockMvc mockMvc;
  
  @Test
  void should_return_404_when_element_is_lower_than_zero() throws Exception {
    mockMvc
      .perform(get("/api/fibonacci/-1"))
      .andExpect(status().isBadRequest());
  
    verifyNoInteractions(fibonacciCalculator);
  }
  
  @Test
  void should_return_200_when_element_is_zero_or_greater() throws Exception {
    mockMvc
      .perform(get("/api/fibonacci/0"))
      .andExpect(status().isOk());
  
    verify(fibonacciCalculator, times(1)).calculateNthTerm(0);
    verifyNoMoreInteractions(fibonacciCalculator);
  }
}