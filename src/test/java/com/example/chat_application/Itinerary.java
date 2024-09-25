package com.example.chat_application;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Itinerary", namespace = "http://travelcompany.example.org/reservation/travel")
@XmlAccessorType(XmlAccessType.FIELD)
public class Itinerary {

  @XmlElement(name = "departure", namespace = "http://travelcompany.example.org/reservation/travel")
  private Departure departure;

  @XmlElement(name = "return", namespace = "http://travelcompany.example.org/reservation/travel")
  private Return returnV;

  public Departure getDeparture() {
    return departure;
  }

  public void setDeparture(Departure departure) {
    this.departure = departure;
  }

  public Return getReturnV() {
    return returnV;
  }

  public void setReturnV(Return returnV) {
    this.returnV = returnV;
  }
}
