package com.example.chat_application.generic;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.namespace.QName;

public class GenericNameAdapter<T> extends XmlAdapter<T, Object> {

  @Override
  public T marshal(Object v) throws JAXBException {
    // Determine element name based on object type
    String elementName = getXmlElementName(v.getClass());
    System.out.print("element name:");
    System.out.println(elementName);
    return new JAXBElement<>(new QName(elementName),  (java.lang.Class<T>) v.getClass(),(T) v).getValue();
//    return new JAXBElement<>(new QName(v.getClass().getSimpleName()),  (Class<Object>) v.getClass(), v);
  }

  @Override
  public Object unmarshal(Object v) throws JAXBException {
    // Handle unmarshalling with dynamic element name (if necessary)
    return v;
  }

  private String getXmlElementName(Class<?> clazz) {
    // Implement logic to determine element name based on class information
    // For example, using annotations or class name reflection

    // Simple example:
    String className = clazz.getSimpleName();
    return className; // Or apply other transformations as needed
  }
}
