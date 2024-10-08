package com.example.chat_application.preprompt;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "Envelope", namespace = "http://www.w3.org/2003/05/soap-envelope")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Envelope", propOrder = {"header", "body"})
public class GetPrePromptResultEnvelop {

  @XmlElement(name = "Header", namespace = "http://www.w3.org/2003/05/soap-envelope")
  private Header header;
  @XmlElement(name = "Body", namespace = "http://www.w3.org/2003/05/soap-envelope")
  private Body body;


  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  @XmlRootElement(name = "Header", namespace = "http://www.w3.org/2003/05/soap-envelope")
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(name = "header", propOrder = {"action", "messageId", "replyTo", "to"})
  public static class Header {

    @XmlElement(name = "Action", namespace = "http://schemas.xmlsoap.org/ws/2004/08/addressing")
    private String action;
    @XmlElement(name = "MessageID", namespace = "http://schemas.xmlsoap.org/ws/2004/08/addressing")
    private String messageId;
    @XmlElement(name = "ReplyTo", namespace = "http://schemas.xmlsoap.org/ws/2004/08/addressing")
    private ReplyTo replyTo;

    @XmlElement(name = "To", namespace = "http://schemas.xmlsoap.org/ws/2004/08/addressing")
    private To to;



    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class ReplyTo {

      @XmlElement(name = "Address")
      private String address;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class To {

      @XmlAttribute(name = "s:mustUnderstand")
      private int mustUnderstand = 1;

      @XmlValue
      private String value;
    }
  }

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  @XmlRootElement
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(name = "body", propOrder = {"getPrePromptResult"}, namespace = "")
  public static class Body {

    @XmlAttribute(name = "xmlns:xsi")
    private final String xsiNamespace = "http://www.w3.org/2001/XMLSchema-instance";

    @XmlAttribute(name = "xmlns:xsd")
    private final String xsdNamespace = "http://www.w3.org/2001/XMLSchema";


    @XmlElement(name = "GetPrePromptResult")
    private GetPrePromptResult getPrePromptResult;

  }

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  @XmlRootElement(name = "GetPrePromptResult")
  @XmlAccessorType(XmlAccessType.FIELD)
//  @XmlType(name = "getPrePromptResult", propOrder = {"authenticationContextId", "languageCode",
//      "serverContextId"})
  @XmlType(name = "getPrePromptResult", propOrder = {"authenticationContextId", "languageCode",
      "serverContextId"})
  public static class GetPrePromptResult {

    @XmlAttribute(name = "xmlns")
    private final String xsiNamespace = "http://www.hp.com/schemas/imaging/OXPd/service/authenticationagent/2013/03/01";

    private String authenticationContextId;
    private String languageCode;
    private String serverContextId;

  }
}