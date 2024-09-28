@XmlSchema(
    elementFormDefault = XmlNsForm.QUALIFIED,
    namespace = "http://www.example.com/FOO",
    xmlns = {
        @XmlNs(prefix = "env", namespaceURI = "http://www.w3.org/2003/05/soap-envelope"),
        @XmlNs(prefix = "m", namespaceURI = "http://travelcompany.example.org/reservation"),
        @XmlNs(prefix = "n", namespaceURI = "http://mycompany.example.com/employees"),
        @XmlNs(prefix = "p", namespaceURI = "http://travelcompany.example.org/reservation/travel")

    }
)
package com.example.chat_application.xml;

import jakarta.xml.bind.annotation.XmlNs;
import jakarta.xml.bind.annotation.XmlNsForm;
import jakarta.xml.bind.annotation.XmlSchema;