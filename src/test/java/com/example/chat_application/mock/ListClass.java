package com.example.chat_application.mock;


import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ListClass {

  List<Integer> numbers = new ArrayList<>();

  public Integer addElement(Integer e) {
     numbers.add(e);
    return numbers.size();
  }

}
