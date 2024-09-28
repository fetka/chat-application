
@XmlSchema(
    elementFormDefault = XmlNsForm.QUALIFIED,
    namespace = "http://www.example.com/FOO",
    xmlns = {
        @XmlNs(prefix = "bar", namespaceURI = "http://www.example.com/BAR"),
        @XmlNs(prefix = "foo", namespaceURI = "http://www.example.com/FOO"),
        @XmlNs(prefix = "other", namespaceURI = "http://www.example.com/OTHER")

    }
)
package com.example.chat_application.example;

import jakarta.xml.bind.annotation.XmlNs;
import jakarta.xml.bind.annotation.XmlNsForm;
import jakarta.xml.bind.annotation.XmlSchema;