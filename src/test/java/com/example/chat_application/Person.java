package com.example.chat_application;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public final class Person {
  public String firstName;
  public String lastName;
  public List<String> phoneNumbers = new ArrayList<>();

  @JacksonXmlElementWrapper(useWrapping = false)
  public List<Address> address = new ArrayList<>();

  //standard setters and getters

}