package com.example.chat_application.generic;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "Envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class Envelope2 {

  @XmlElement(name = "Header", required = true, namespace = "http://www.w3.org/2003/05/soap-envelope")
  private Header header;

  @XmlElement(name = "Body", namespace = "http://www.w3.org/2003/05/soap-envelope")
  private Body<?> body; // Generic type

  @Data
  @ToString
  @NoArgsConstructor
  @AllArgsConstructor
  @XmlAccessorType(XmlAccessType.FIELD)
  public static class Header { // Removed @XmlRootElement

    @XmlElement(name = "Action", required = true, namespace = "http://schemas.xmlsoap.org/ws/2004/08/addressing")
    private String action;

    @XmlElement(name = "MessageID", namespace = "http://schemas.xmlsoap.org/ws/2004/08/addressing")
    private String messageId;

    @XmlElement(name = "ReplyTo", namespace = "http://schemas.xmlsoap.org/ws/2004/08/addressing")
    private ReplyTo replyTo;

    @XmlElement(name = "To", namespace = "http://schemas.xmlsoap.org/ws/2004/08/addressing")
    private String to;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class ReplyTo {

      @XmlElement(name = "Address", namespace = "http://schemas.xmlsoap.org/ws/2004/08/addressing")
      private String address;
    }
  }

  @Data
  @AllArgsConstructor
  @XmlAccessorType(XmlAccessType.FIELD) // Removed @XmlRootElement
  public static class Body<T> {

//    @XmlElement
//    private T object;

    @XmlElement @XmlJavaTypeAdapter(GenericNameAdapter.class)
//    @XmlElement
    private T object;

//    public Body(T object) {
//      this.object = new JAXBElement<>(new QName(object.getClass().getSimpleName()),  (Class<T>) object.getClass(), object).getValue();
//    }
  }
}

