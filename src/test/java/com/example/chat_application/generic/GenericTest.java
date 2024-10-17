package com.example.chat_application.generic;

import static com.example.chat_application.LogOut.logCyan;

import com.example.chat_application.generic.Envelope.Body;
import com.example.chat_application.generic.Envelope.Header;
import com.example.chat_application.generic.Envelope.Header.ReplyTo;
import com.example.chat_application.preprompt.GetPrePromptResultEnvelop.Header.To;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;
import javax.xml.namespace.QName;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
//import javax.xml.namespace.QName;

@SpringBootTest
public class GenericTest {

  @Test
  @SneakyThrows
  public void test1() {
    OwnedAccessoryRecord ownedAccessoryRecord = new OwnedAccessoryRecord();
    Wrapper<OwnedAccessoryRecord> wrapper = new Wrapper<>(ownedAccessoryRecord);
    ownedAccessoryRecord.setProductId("productId=24234");
    ownedAccessoryRecord.setCallback(null);
    Envelope envelope = new Envelope();
    ReplyTo replyTo = new ReplyTo();
    replyTo.setAddress("address");
    envelope.setHeader(new Header("action", "message", replyTo, "value"));
    Body<OwnedAccessoryRecord> body = new Body<>(ownedAccessoryRecord);
    envelope.setBody(body);
    System.out.println(envelope.getBody().getObject());
    JAXBContext jaxbContext = JAXBContext.newInstance(Envelope.class, OwnedAccessoryRecord.class);
    JAXBContext jaxbContext2 = JAXBContext.newInstance(OwnedAccessoryRecord.class);
    Marshaller marshaller = jaxbContext.createMarshaller();
    Marshaller marshaller2 = jaxbContext2.createMarshaller();

    StringWriter stringWriter = new StringWriter();
    marshaller.marshal(envelope, stringWriter);
    System.out.println(stringWriter.toString());

  }

  @Test
  @SneakyThrows
  public void test2() {
    OwnedAccessoryRecord ownedAccessoryRecord = new OwnedAccessoryRecord();
    ownedAccessoryRecord.setProductId("33333333");
    ownedAccessoryRecord.setServerContextId("22222222222");
    ownedAccessoryRecord.setVendorId("5555555");
    ownedAccessoryRecord.setCallback(null);
    Wrapper<OwnedAccessoryRecord> wrapper = new Wrapper<>(ownedAccessoryRecord); // Wrapper usage can be optional

    Envelope2 envelope = new Envelope2();
    Envelope2.Header.ReplyTo replyTo = new Envelope2.Header.ReplyTo();
    replyTo.setAddress("address");
    envelope.setHeader(new Envelope2.Header("action", "message", replyTo, "value"));
    Envelope2.Body<OwnedAccessoryRecord> body = new Envelope2.Body<>(ownedAccessoryRecord);
    envelope.setBody(body);

    // Accessing data:
//    System.out.println(envelope.getBody().getObject());

    JAXBContext jaxbContext = JAXBContext.newInstance(Envelope2.class, OwnedAccessoryRecord.class); // Single context for all classes
    Marshaller marshaller = jaxbContext.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);


    StringWriter stringWriter = new StringWriter();
    marshaller.marshal(envelope,
        stringWriter);
    System.out.println(stringWriter.toString());
    logCyan(stringWriter.toString());
  }

  @Test
  void test3(){
//    ObjectFactory factory = new ObjectFactoryMine();
//    JAXBElement<String> createMessageDescription = factory.createMessageDescription("description");
//    message.setDescription(createMessageDescription);
  }

}
