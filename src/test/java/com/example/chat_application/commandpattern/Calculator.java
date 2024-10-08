package com.example.chat_application.commandpattern;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@Service
public class Calculator {


  public float calculateUsingFactory(float a, float b, String operator) {
    Operation targetOperation = OperatorFactory
        .getOperation(operator)
        .orElseThrow(() -> new IllegalArgumentException("Invalid Operator"));
    return targetOperation.apply(a, b);
  }

}
