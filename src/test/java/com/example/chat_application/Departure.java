package com.example.chat_application;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "departure", namespace = "http://travelcompany.example.org/reservation/travel")
@XmlAccessorType(XmlAccessType.FIELD)
public class Departure {

  @XmlElement(name = "departing", namespace = "http://travelcompany.example.org/reservation/travel")
  private String departing;

  @XmlElement(name = "arriving", namespace = "http://travelcompany.example.org/reservation/travel")
  private String arriving;

  @XmlElement(name = "departureDate", namespace = "http://travelcompany.example.org/reservation/travel")
  private Date departureDate;

  @XmlElement(name = "departureTime", namespace = "http://travelcompany.example.org/reservation/travel")
  private String departureTime;

  @XmlElement(name = "seatPreference", namespace = "http://travelcompany.example.org/reservation/travel")
  private String seatPreference;

  public String getDeparting() {
    return departing;
  }

  public void setDeparting(String departing) {
    this.departing = departing;
  }

  public String getArriving() {
    return arriving;
  }

  public void setArriving(String arriving) {
    this.arriving = arriving;
  }

  public Date getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(Date departureDate) {
    this.departureDate = departureDate;
  }

  public String getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(String departureTime) {
    this.departureTime = departureTime;
  }

  public String getSeatPreference() {
    return seatPreference;
  }

  public void setSeatPreference(String seatPreference) {
    this.seatPreference = seatPreference;
  }
}
