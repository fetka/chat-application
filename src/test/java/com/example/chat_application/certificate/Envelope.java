package com.example.chat_application.certificate;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "Envelope", namespace = "http://www.w3.org/2003/05/soap-envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class Envelope {

  @XmlElement(name = "Header", required = true)
  private Header header;

  @XmlElement(name = "Body", required = true)
  private Body body;

  // Getters and setters (omitted for brevity)
}

@Data
@XmlAccessorType(XmlAccessType.FIELD)
class Header {
  // Header elements omitted for brevity
}

@Data
@XmlAccessorType(XmlAccessType.FIELD)
class Body {
  @XmlElement(name = "ImportCertificate", namespace = "http://www.hp.com/schemas/imaging/OXPd/service/certificatemanagement/2010/04/14")
  private ImportCertificate importCertificate;

  // Getter and setter (omitted for brevity)
}

@Data
@XmlAccessorType(XmlAccessType.FIELD)
class ImportCertificate {
  @XmlElement(name = "certificate", required = true)
  private String certificateValue;

  // Getter and setter (omitted for brevity)
}