package com.example.chat_application.json_xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * In summary, this code defines a Java class named Person that represents a person with first and
 * last name properties. The annotations ensure that the class can be easily mapped to and from XML
 * and JSON formats, allowing for seamless data exchange and manipulations.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
/* @XmlRootElement is essential for marshalling and unmarshalling XML data using JAXB */
@XmlRootElement(name = "person")
/* @XmlAccessorType specifies that JAXB should map fields directly to XML elements.
  This means that each  field in the Person class will correspond to an element in the XML document. */
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

  /* specifies that the firstName field should be mapped to an XML element named "firstName" */
  @XmlElement(name = "firstName")

  /* specific to JAXB2-JSON, indicates that the JSON property name should be "first_name"
   * instead of the default "firstName". This allows you to customize the JSON output. */
  @JacksonXmlProperty(localName = "first_name")
  private String firstName;

  /* specifies that the lastName field should be mapped to an XML element named "lastName" */
  @XmlElement(name = "lastName")
  /* specific to JAXB2-JSON, indicates that the JSON property name should be "last_name"
   * instead of the default "lastName". This allows you to customize the JSON output. */
  @JacksonXmlProperty(localName = "last_name")
  private String lastName;

  // Getters and setters
}