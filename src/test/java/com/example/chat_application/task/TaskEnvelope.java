package com.example.chat_application.task;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyElement;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "Envelope", namespace = "http://www.w3.org/2003/05/soap-envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskEnvelope {

  @XmlElement(name = "Header", required = true, namespace = "http://www.w3.org/2003/05/soap-envelope")
  private Header header;

  @XmlElement(name = "Body", namespace = "http://www.w3.org/2003/05/soap-envelope")
  private Body body;

  @Data
  @ToString
  @NoArgsConstructor
  @AllArgsConstructor
  @XmlRootElement(name = "Header", namespace =  "http://www.w3.org/2003/05/soap-envelope")
  @XmlAccessorType(XmlAccessType.FIELD)
  public static class Header {

    @XmlElement(name = "Action", required = true, namespace = "http://schemas.xmlsoap.org/ws/2004/08/addressing")
    private String action;

    @XmlElement(name = "MessageID", namespace = "http://schemas.xmlsoap.org/ws/2004/08/addressing")
    private String messageId;

    @XmlElement(name = "ReplyTo", namespace = "http://schemas.xmlsoap.org/ws/2004/08/addressing")
    private ReplyTo replyTo;

    @XmlElement(name = "To", namespace = "http://schemas.xmlsoap.org/ws/2004/08/addressing")
    private String to;

    @Data
    @XmlRootElement(name = "ReplyTo", namespace = "http://schemas.xmlsoap.org/ws/2004/08/addressing")
    @NoArgsConstructor
    @AllArgsConstructor
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class ReplyTo {

      @XmlElement(name = "Address", namespace = "http://schemas.xmlsoap.org/ws/2004/08/addressing")
      private String address;
    }
  }


  @Data
  @XmlRootElement(name = "Body", namespace = "http://www.w3.org/2003/05/soap-envelope")
  @XmlAccessorType(XmlAccessType.FIELD)
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Body {

    @XmlElement(name = "RegisterOwnedAccessory", namespace = "http://www.hp.com/schemas/imaging/OXPd/service/accessories/2010/04/14")
    private RegisterOwnedAccessory registerOwnedAccessory;


    @Data
    @XmlRootElement(name = "RegisterOwnedAccessory", namespace = "http://www.hp.com/schemas/imaging/OXPd/service/accessories/2010/04/14")
    @XmlAccessorType(XmlAccessType.FIELD)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RegisterOwnedAccessory {

      @XmlElement(name = "ownedAccessoryRecord")
      private OwnedAccessoryRecord ownedAccessoryRecord;

    }

    @Data
    @XmlRootElement(name = "ownedAccessoryRecord")
    @XmlAccessorType(XmlAccessType.FIELD)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OwnedAccessoryRecord {

      @XmlElement(name = "vendorId")
      private String vendorId;

      @XmlElement(name = "productId")
      private String productId;

      @XmlElement(name = "serverContextId", required = true)
      private String serverContextId;

      @XmlElement(name = "callback")
      private Callback callback;


      @Data
      @XmlRootElement(name = "callback")
      @XmlAccessorType(XmlAccessType.FIELD)
      @NoArgsConstructor
      @AllArgsConstructor
      public static class Callback {

        @XmlElement(name = "uri",  namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
        private String uri;

        @XmlElement(name = "binding",  namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
        private String binding;

        @XmlElement(name = "networkCredential",  namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
        private NetworkCredential networkCredential;

        @XmlElement(name = "connectTimeout",  namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
        private String connectTimeout;

        @XmlElement(name = "responseTimeout",  namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
        private String responseTimeout;

        @Data
        @XmlRootElement(name = "callback")
        @XmlAccessorType(XmlAccessType.FIELD)
        @NoArgsConstructor
        @AllArgsConstructor
        public static class NetworkCredential {

          @XmlElement(name = "userName",  namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
          private String userName;

          @XmlElement(name = "Password",  namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
          private String password;
        }
      }
    }

  }
}
