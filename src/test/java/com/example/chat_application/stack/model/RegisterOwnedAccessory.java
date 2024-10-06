package com.example.chat_application.stack.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Data;

@Data
@XmlRootElement(name = "RegisterOwnedAccessory", namespace = "http://www.hp.com/schemas/imaging/OXPd/service/accessories/2010/04/14")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegisterOwnedAccessory", propOrder = {
    "ownedAccessoryRecord"
})
public class RegisterOwnedAccessory {

  @XmlElement(name = "ownedAccessoryRecord")
  private OwnedAccessoryRecord ownedAccessoryRecord;
}


