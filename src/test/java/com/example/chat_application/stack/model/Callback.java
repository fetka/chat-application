package com.example.chat_application.stack.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Data;

@Data
@XmlRootElement(name = "callback")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Callback", propOrder = {
    "uri",
    "binding",
    "networkCredentials",
    "connectionTimeout",
    "responseTimeout"
})
public class Callback {

  @XmlElement(name = "uri", namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
  private String uri;

  @XmlElement(name = "binding", namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
  private String binding;

  @XmlElement(name = "networkCredentials", namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
  private NetworkCredentials networkCredentials;

  @XmlElement(name = "connectionTimeout", namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
  private int connectionTimeout;

  @XmlElement(name = "responseTimeout", namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
  private int responseTimeout;
}
