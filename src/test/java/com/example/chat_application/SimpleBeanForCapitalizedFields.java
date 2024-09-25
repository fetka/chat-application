package com.example.chat_application;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SimpleBeanForCapitalizedFields {

  @JsonProperty("X")
  public int x = 1;
  public int y = 2;
}
