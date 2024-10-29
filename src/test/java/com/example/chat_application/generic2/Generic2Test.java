package com.example.chat_application.generic2;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringReader;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Generic2Test {

String input = """
    """;
  @Test
  @SneakyThrows
  public void test1() {
    Envelope envelope = new Envelope();
    BaseBodyElement bodyElement = envelope.getBodyElement();

    if (bodyElement instanceof BodyTypeA) {
      BodyTypeA bodyTypeA = (BodyTypeA) bodyElement;
      // Process BodyTypeA
    } else if (bodyElement instanceof BodyTypeB) {
      BodyTypeB bodyTypeB = (BodyTypeB) bodyElement;
      // Process BodyTypeB
    } else {
      // Handle unknown body type
    }

    JAXBContext jaxbContext = JAXBContext.newInstance(Envelope.class);
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

    Envelope envelope = (Envelope) unmarshaller.unmarshal(new StringReader(input));
  }
}
