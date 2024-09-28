package com.example.chat_application;

import com.example.chat_application.xml.Itinerary;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "Body", namespace = "http://www.w3.org/2003/05/soap-envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class SOAPBody implements Serializable {

  private static final long serialVersionUID = 1L;

  @XmlElement(name = "itinerary", namespace = "http://travelcompany.example.org/reservation/travel")
  private Itinerary itinerary;

  public Itinerary getItinerary() {
    return itinerary;
  }

  public void setItinerary(Itinerary itinerary) {
    this.itinerary = itinerary;
  }
}
