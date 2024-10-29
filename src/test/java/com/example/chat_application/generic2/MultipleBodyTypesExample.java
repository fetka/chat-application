package com.example.chat_application.generic2;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;
import lombok.SneakyThrows;

public class MultipleBodyTypesExample {

  @SneakyThrows
  public static void main(String[] args) throws Exception {
    // Load the XML document
    JAXBContext jaxbContext = JAXBContext.newInstance(Envelope.class);
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

    Envelope envelope = (Envelope) unmarshaller.unmarshal(new
        File("input.xml"));

    // Determine the body type and process accordingly
    BaseBodyElement bodyElement = envelope.getBodyElement();

    if (bodyElement instanceof BodyTypeA) {
      BodyTypeA bodyTypeA = (BodyTypeA) bodyElement;
      // Process BodyTypeA
      System.out.println("Body type: A");
      System.out.println(bodyTypeA.getString());
    } else if (bodyElement instanceof BodyTypeB) {
      BodyTypeB bodyTypeB = (BodyTypeB) bodyElement;
      // Process BodyTypeB
      System.out.println("Body type: B");
      System.out.println(bodyTypeB.getString());
    } else {
      System.out.println("Unknown body type");
    }
  }

}
