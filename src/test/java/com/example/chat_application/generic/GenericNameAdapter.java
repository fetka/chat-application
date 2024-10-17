package com.example.chat_application.generic;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.namespace.QName;

public class GenericNameAdapter<T> extends XmlAdapter<Object, Object> {

  @Override
  public Object marshal(Object v) throws JAXBException {
    // Determine element name based on object type
    String elementName = getXmlElementName(v.getClass());

    return new JAXBElement<>(new QName(v.getClass().getSimpleName()),  (Class<Object>) v.getClass(), v);
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
    return className.toLowerCase(); // Or apply other transformations as needed
  }
}
