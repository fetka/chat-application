package com.example.chat_application;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "Reservation", namespace = "http://travelcompany.example.org/reservation")
@XmlAccessorType(XmlAccessType.FIELD)
public class Reservation {
  @XmlElement(name = "reference", namespace = "http://travelcompany.example.org/reservation")
  String reference;

  @XmlElement(name = "dateAndTime" , namespace = "http://travelcompany.example.org/reservation")
  Date dateAndTime;

}
