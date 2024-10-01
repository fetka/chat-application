package com.example.chat_application.task;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@XmlRootElement(name = "callback")
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
@XmlType(name = "Callback", propOrder = {
    "uri",
    "binding",
    "networkCredential",
    "connectTimeout",
    "responseTimeout"
})
public class Callback {

  @XmlElement(name = "uri", namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
  private String uri;

  @XmlElement(name = "binding", namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
  private String binding;

  @XmlElement(name = "networkCredential", namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
  private NetworkCredential networkCredential;

  @XmlElement(name = "connectTimeout", namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
  private String connectTimeout;

  @XmlElement(name = "responseTimeout", namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
  private String responseTimeout;
}
