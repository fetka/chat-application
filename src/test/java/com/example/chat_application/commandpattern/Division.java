package com.example.chat_application.commandpattern;

public class Division implements Operation {

  @Override
  public float apply(float a, float b) {
    return (a / b);
  }
}
