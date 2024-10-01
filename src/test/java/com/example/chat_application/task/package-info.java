@XmlSchema(
    elementFormDefault = XmlNsForm.QUALIFIED,
    namespace = "http://www.hp.com/schemas/imaging/OXPd/service/accessories/2010/04/14",
    xmlns = {
        @XmlNs(prefix = "ns2", namespaceURI = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14"),
        @XmlNs(prefix = "env", namespaceURI = "http://www.w3.org/2003/05/soap-envelope"),

    }
)
package com.example.chat_application.task;

import jakarta.xml.bind.annotation.XmlNs;
import jakarta.xml.bind.annotation.XmlNsForm;
import jakarta.xml.bind.annotation.XmlSchema;