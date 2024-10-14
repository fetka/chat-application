package com.example.chat_application.stack.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@XmlRootElement(name = "ownedAccessoryRecord")
@XmlAccessorType(XmlAccessType.FIELD)
//@NoArgsConstructor
//@AllArgsConstructor
@XmlType(name = "ownedAccessoryRecord", propOrder = {
    "vendorId",
    "productId",
    "serverContextId",
    "callback"
})
public class  OwnedAccessoryRecord {

  @XmlElement(name = "vendorId")
  private String vendorId;

  @XmlElement(name = "productId")
  private String productId;

  @XmlElement(name = "serverContextId", required = true)
  private String serverContextId;

  @XmlElement(name = "callback")
  private Callback callback;
}
