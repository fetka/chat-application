@XmlSchema(
    elementFormDefault = XmlNsForm.QUALIFIED,
    namespace = "http://www.w3.org/2003/05/soap-envelope",
    xmlns = {
        @XmlNs(prefix = "s", namespaceURI = "http://www.w3.org/2003/05/soap-envelope"),
        @XmlNs(prefix = "S", namespaceURI = "http://www.w3.org/2003/05/soap-envelope"),
        @XmlNs(prefix = "env", namespaceURI = "http://www.w3.org/2003/05/soap-envelope"),
        @XmlNs(prefix = "xsi", namespaceURI = "http://www.w3.org/2001/XMLSchema-instance"),
        @XmlNs(prefix = "xsd", namespaceURI = "http://www.w3.org/2001/XMLSchema"),
        @XmlNs(prefix = "a", namespaceURI = "http://schemas.xmlsoap.org/ws/2004/08/addressing"),
//        @XmlNs(prefix = "ns2", namespaceURI = "http://www.hp.com/schemas/imaging/OXPd/service/authentication/2013/03/01"),
//        SetConfiguration
        @XmlNs(prefix = "ns2", namespaceURI = "http://www.hp.com/schemas/imaging/OXPd/service/authorization/2013/03/01"),
        @XmlNs(prefix = "ns3", namespaceURI = "http://www.hp.com/schemas/imaging/OXPd/domain/security/2013/03/01"),

    }
)
package com.example.chat_application.task.authentication;

import jakarta.xml.bind.annotation.XmlNs;
import jakarta.xml.bind.annotation.XmlNsForm;
import jakarta.xml.bind.annotation.XmlSchema;