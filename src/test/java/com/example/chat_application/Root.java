package com.example.chat_application;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "root", namespace = "http://www.example.com/FOO")
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {

  @XmlElement(name = "a", namespace = "http://www.example.com/BAR")
  private String a;

  @XmlElement(name = "b", namespace = "http://www.example.com/FOO")
  private String b;

  @XmlElement(name = "c", namespace = "http://www.example.com/OTHER")
  private String c;

//  public String getA() {
//    return a;
//  }
//
//  public void setA(String a) {
//    this.a = a;
//  }
//
//  public String getB() {
//    return b;
//  }
//
//  public void setB(String b) {
//    this.b = b;
//  }
//
//  public String getC() {
//    return c;
//  }
//
//  public void setC(String c) {
//    this.c = c;
//  }

}
