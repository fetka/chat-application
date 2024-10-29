package com.example.chat_application.generic2;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "bodyElement")
@XmlSeeAlso({BodyTypeA.class, BodyTypeB.class})
public abstract class BaseBodyElement {
  // Common properties if any
}

