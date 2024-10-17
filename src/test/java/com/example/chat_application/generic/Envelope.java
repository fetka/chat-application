package com.example.chat_application.generic;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "Envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class Envelope {

  @XmlElement(name = "Header", required = true, namespace = "http://www.w3.org/2003/05/soap-envelope")
  private Header header;

  @XmlElement(name = "Body", namespace = "http://www.w3.org/2003/05/soap-envelope")
  private Body<?> body;

  @Data
  @ToString
  @NoArgsConstructor
  @AllArgsConstructor
//  @XmlRootElement(name = "Header", namespace = "http://www.w3.org/2003/05/soap-envelope")
  @XmlAccessorType(XmlAccessType.FIELD)
  public static class Header {

    @XmlElement(name = "Action", required = true, namespace = "http://schemas.xmlsoap.org/ws/2004/08/addressing")
    private String action;

    @XmlElement(name = "MessageID", namespace = "http://schemas.xmlsoap.org/ws/2004/08/addressing")
    private String messageId;

    @XmlElement(name = "ReplyTo", namespace = "http://schemas.xmlsoap.org/ws/2004/08/addressing")
    private ReplyTo replyTo;

    @XmlElement(name = "To", namespace = "http://schemas.xmlsoap.org/ws/2004/08/addressing")
    private String to;

    @Data
//    @XmlRootElement(name = "ReplyTo", namespace = "http://schemas.xmlsoap.org/ws/2004/08/addressing")
    @NoArgsConstructor
    @AllArgsConstructor
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class ReplyTo {

      @XmlElement(name = "Address", namespace = "http://schemas.xmlsoap.org/ws/2004/08/addressing")
      private String address;
    }
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
//  @XmlRootElement(name = "Body", namespace = "http://www.w3.org/2003/05/soap-envelope")
  @XmlAccessorType(XmlAccessType.FIELD)
  public static class Body<T> {

    @XmlElement
    private T object;
  }
}
