package com.example.chat_application;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "Envelope", namespace = "http://www.w3.org/2003/05/soap-envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class SOAPEnvelope implements Serializable {

  private static final long serialVersionUID = 1L;


  @XmlElement(name = "Header", namespace = "http://www.w3.org/2003/05/soap-envelope")
  private SOAPHeader header;

  @XmlElement(name = "Body", namespace = "http://www.w3.org/2003/05/soap-envelope")
  private SOAPBody body;

  // Getters and setters for header and body


  public SOAPHeader getHeader() {
    return header;
  }

  public void setHeader(SOAPHeader header) {
    this.header = header;
  }

  public SOAPBody getBody() {
    return body;
  }

  public void setBody(SOAPBody body) {
    this.body = body;
  }

}

