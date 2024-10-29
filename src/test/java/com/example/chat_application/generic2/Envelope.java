package com.example.chat_application.generic2;

import jakarta.xml.bind.annotation.*;
import lombok.Data;
import lombok.Value;

@Data
@XmlRootElement(name = "envelope")
public class Envelope {

  @XmlElement(name = "bodyElement")
  protected BaseBodyElement bodyElement;

  // Getters and setters for bodyElement
}