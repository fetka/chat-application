package com.example.chat_application.mock;


import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class MockTest {

  @MockBean
  ListClass listClass;

  @BeforeEach
  public void setup() {
//    listClass = new ListClass();
  }

  @Test
  public void test1() {
    init();
    Integer i = listClass.addElement(1);
    Integer e = listClass.addElement(1);
    System.out.println(i);
    System.out.println(e);
    System.out.println(listClass.getNumbers().size());
  }

  private void init() {
    when(listClass.addElement(anyInt())).thenReturn(3);
  }

}
