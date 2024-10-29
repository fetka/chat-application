package com.example.chat_application.generic2;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlValue;
import lombok.Data;

@Data
@XmlRootElement(name = "bodyTypeA")
public class BodyTypeA extends BaseBodyElement {
  // Properties specific to BodyTypeA
  @XmlValue
  private String string;
}
