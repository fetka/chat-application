package com.example.chat_application.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Passenger", namespace = "http://mycompany.example.com/employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class Passenger {

  @XmlElement(name = "name", namespace = "http://mycompany.example.com/employees")
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
