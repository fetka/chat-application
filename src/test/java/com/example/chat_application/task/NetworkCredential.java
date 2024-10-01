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
@XmlRootElement(name = "NetworkCredential", namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
@XmlType(name = "NetworkCredential", propOrder = {
    "userName",
    "password"
})
public class NetworkCredential {

  @XmlElement(name = "userName", namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
  private String userName;

  @XmlElement(name = "Password", namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
  private String password;
}
