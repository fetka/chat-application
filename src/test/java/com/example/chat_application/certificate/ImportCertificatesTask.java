package com.example.chat_application.certificate;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "Envelope", namespace = "http://www.w3.org/2003/05/soap-envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportCertificatesTask {

  @XmlElement(name = "Header", required = true, namespace = "http://www.w3.org/2003/05/soap-envelope")
  private Header header;

  @XmlElement(name = "Body", namespace = "http://www.w3.org/2003/05/soap-envelope")
  private Body body;

  @Data
  @ToString
  @NoArgsConstructor
  @AllArgsConstructor
  @XmlRootElement(name = "Header")
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
    @XmlRootElement(name = "ReplyTo", namespace = "http://schemas.xmlsoap.org/ws/2004/08/addressing")
    @NoArgsConstructor
    @AllArgsConstructor
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class ReplyTo {

      @XmlElement(name = "Address", namespace = "http://schemas.xmlsoap.org/ws/2004/08/addressing")
      private String address;
    }
  }

  @Data
  @XmlRootElement(name = "Body")
  @XmlAccessorType(XmlAccessType.FIELD)
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Body {

    @XmlElement(name = "ImportCertificate", namespace = "http://www.hp.com/schemas/imaging/OXPd/service/certificatemanagement/2010/04/14")
    private ImportCertificate importCertificate;

  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @XmlRootElement(name = "ImportCertificate", namespace = "http://www.hp.com/schemas/imaging/OXPd/service/certificatemanagement/2010/04/14")
  @XmlAccessorType(XmlAccessType.FIELD)
  public static class ImportCertificate {


    @XmlElement(name = "certificate", namespace = "http://www.hp.com/schemas/imaging/OXPd/service/certificatemanagement/2010/04/14")
    private Certificate certificate;

  }
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @XmlRootElement(name = "certificate")
  @XmlAccessorType(XmlAccessType.FIELD)
  public static class Certificate {

    @XmlValue
    private String value;
  }

}
