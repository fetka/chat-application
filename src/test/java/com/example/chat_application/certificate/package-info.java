@XmlSchema(
    elementFormDefault = XmlNsForm.QUALIFIED,
    namespace = "http://www.w3.org/2003/05/soap-envelope",
    xmlns = {
        @XmlNs(prefix = "env", namespaceURI = "http://www.w3.org/2003/05/soap-envelope"),
//        @XmlNs(prefix = "a", namespaceURI = "http://schemas.xmlsoap.org/ws/2004/08/addressing"),
//        @XmlNs(prefix = "xsi", namespaceURI = "http://www.w3.org/2001/XMLSchema-instance"),
//        @XmlNs(prefix = "xsd", namespaceURI = "http://www.w3.org/2001/XMLSchema"),
//        @XmlNs(prefix = "s", namespaceURI = "http://www.w3.org/2003/05/soap-envelope"),
//        @XmlNs(prefix = "a", namespaceURI = "http://schemas.xmlsoap.org/ws/2004/08/addressing")


//        ns2="http://www.hp.com/schemas/imaging/OXPd/service/authentication/2013/03/01
    }
)
package com.example.chat_application.certificate;

import jakarta.xml.bind.annotation.XmlNs;
import jakarta.xml.bind.annotation.XmlNsForm;
import jakarta.xml.bind.annotation.XmlSchema;