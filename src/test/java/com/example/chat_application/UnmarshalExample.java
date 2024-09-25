package com.example.chat_application;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import java.io.StringReader;

public class UnmarshalExample {
//  <?xml version='1.0' Encoding='UTF-8' ?>
  static String xml = """
    
    <env:Envelope xmlns:env="http://www.w3.org/2003/05/soap-envelope">
          <n:name xmlns:n="http://mycompany.example.com/employees">Fred Bloggs</n:name>
    </env:Envelope>
    """;

  static String xmlH =
      """
     <env:Envelope xmlns:env="http://www.w3.org/2003/05/soap-envelope">
        <env:Header>
          <n:name xmlns:n="http://mycompany.example.com/employees">Fred Bloggs</n:name>
         </env:Header> 
    </env:Envelope>
          """;
  static String xmlString= """
     
      <env:Envelope xmlns:env="http://www.w3.org/2003/05/soap-envelope">
       <env:Header>
        <m:reservation xmlns:m="http://travelcompany.example.org/reservation"
      		env:role="http://www.w3.org/2003/05/soap-envelope/role/next">
         <m:reference>uuid:093a2da1-q345-739r-ba5d-pqff98fe8j7d</m:reference>
         <m:dateAndTime>2007-11-29T13:20:00.000-05:00</m:dateAndTime>
        </m:reservation>
        <n:passenger xmlns:n="http://mycompany.example.com/employees"	env:role="http://www.w3.org/2003/05/soap-envelope/role/next">
         <n:name>Fred Bloggs</n:name>
        </n:passenger>
       </env:Header>
       <env:Body>
        <p:itinerary xmlns:p="http://travelcompany.example.org/reservation/travel">
         <p:departure>
           <p:departing>New York</p:departing>
           <p:arriving>Los Angeles</p:arriving>
           <p:departureDate>2007-12-14</p:departureDate>
           <p:departureTime>late afternoon</p:departureTime>
           <p:seatPreference>aisle</p:seatPreference>
         </p:departure>
         <p:return>
           <p:departing>Los Angeles</p:departing>
           <p:arriving>New York</p:arriving>
           <p:departureDate>2007-12-20</p:departureDate>
           <p:departureTime>mid-morning</p:departureTime>
           <p:seatPreference></p:seatPreference>
         </p:return>
        </p:itinerary>
       </env:Body>
      </env:Envelope>
      """;
  public static void main(String[] args) throws Exception {
    JAXBContext jaxbContext = JAXBContext.newInstance(SOAPEnvelope.class);
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

//    String xmlString = "<?xml version='1.0' Encoding='UTF-8' ?> ..."; // Your SOAP envelope XML
    SOAPEnvelope envelope = (SOAPEnvelope) unmarshaller.unmarshal(new StringReader(xmlString));

    // Access the unmarshalled data from the envelope object
//    System.out.println("Passenger name: " + envelope.getHeader().getPassenger().getName());
    System.out.println("Passenger name: " + envelope.getHeader().getPassenger().getName());
    System.out.println("Departure.arriving: " + envelope.getBody().getItinerary().getDeparture().getArriving());
    // ...
  }
}