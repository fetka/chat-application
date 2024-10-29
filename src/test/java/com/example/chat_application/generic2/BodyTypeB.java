package com.example.chat_application.generic2;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlValue;
import lombok.Data;

@Data
@XmlRootElement(name = "bodyTypeB")
public class BodyTypeB extends BaseBodyElement {
  // Properties specific to BodyTypeB
  @XmlValue
  private String string;
}
