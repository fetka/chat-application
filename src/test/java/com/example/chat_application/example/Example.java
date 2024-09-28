package com.example.chat_application.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.PropertyException;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import org.junit.jupiter.api.Test;

public class Example {


  @Data
  @XmlRootElement(name = "person", namespace = "http://www.example.com/FOO")
  @XmlAccessorType(XmlAccessType.FIELD)
  public static class Person {

    @XmlElement(namespace = "http://www.example.com/OTHER")
    private String name;

    @XmlElement(namespace = "http://www.example.com/BAR")
    private int age;

  }

  @Test
  public void main() throws Exception {
    JAXBContext jaxbContext = JAXBContext.newInstance(Person.class,
        MyNamespaceMapperByGemini.class);
    Marshaller marshaller = jaxbContext.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

//    if the package-info.java does not contain appropriate schema definition, this would be the next option
    try {
      marshaller.setProperty("org.glassfish.jaxb.namespacePrefixMapper", new MyNamespaceMapperByGemini());
    } catch (PropertyException e) {
      e.printStackTrace(); // Handle the exception appropriately
    }
    Person person = new Person();
    person.setName("John Doe");
    person.setAge(30);

    marshaller.marshal(person, System.out);
  }
}