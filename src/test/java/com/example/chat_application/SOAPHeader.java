package com.example.chat_application;

import com.example.chat_application.xml.Passenger;
import com.example.chat_application.xml.Reservation;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "Header", namespace = "http://www.w3.org/2003/05/soap-envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class SOAPHeader implements Serializable {

  private static final long serialVersionUID = 1L;
  @XmlElement(name = "reservation", namespace = "http://travelcompany.example.org/reservation")
  private Reservation reservation;

  @XmlElement(name = "passenger", namespace = "http://mycompany.example.com/employees")
  private Passenger passenger;

  public Reservation getReservation() {
    return reservation;
  }

  public void setReservation(Reservation reservation) {
    this.reservation = reservation;
  }

  public Passenger getPassenger() {
    return passenger;
  }

  public void setPassenger(Passenger passenger) {
    this.passenger = passenger;
  }
}
