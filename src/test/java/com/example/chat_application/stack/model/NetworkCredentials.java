package com.example.chat_application.stack.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Data;

@Data
@XmlRootElement(name = "NetworkCredentials", namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NetworkCredentials", propOrder = {
    "userName",
    "password"
})
public class NetworkCredentials {

  @XmlElement(name = "userName", namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
  private String userName;

  @XmlElement(name = "password", namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
  private String password;
}
