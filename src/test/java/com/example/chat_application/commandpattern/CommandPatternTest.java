package com.example.chat_application.commandpattern;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommandPatternTest {

  @Autowired
  Calculator calculator;

  @Test
  public void testFirst() {
    AddCommand addCommand = new AddCommand(5, 3);
    System.out.println(addCommand.execute());
  }

  @Test
  public void testCalculateUsingFactory() {
    var add = calculator.calculateUsingFactory(3, 6, "add");
    var divide = calculator.calculateUsingFactory(3, 6, "divide");
    System.out.println(add);
    System.out.println(divide);
  }
}
