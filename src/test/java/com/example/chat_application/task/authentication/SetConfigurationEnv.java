package com.example.chat_application.task.authentication;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.tomcat.util.http.parser.Authorization;

@Data
@XmlRootElement(name = "Envelope")
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
public class SetConfigurationEnv {

  @XmlElement(name = "Header", required = true)
  private Header header;

  @XmlElement(name = "Body")
  private Body body;

  @Data
  @ToString
  @NoArgsConstructor
  @AllArgsConstructor
  @XmlRootElement(name = "Header")
  @XmlAccessorType(XmlAccessType.FIELD)
  public static class Header {

    @XmlElement(name = "Action", required = true, namespace = "http://schemas.xmlsoap.org/ws/2004/08/addressing")
    private String action;

    @XmlElement(name = "MessageID", namespace = "http://schemas.xmlsoap.org/ws/2004/08/addressing")
    private String messageId;

    @XmlElement(name = "ReplyTo", namespace = "http://schemas.xmlsoap.org/ws/2004/08/addressing")
    private Header.ReplyTo replyTo;

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
  @XmlRootElement(name = "Body")
  @XmlAccessorType(XmlAccessType.FIELD)
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Body {

    @XmlElement(name = "SetConfiguration", namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authorization/2013/03/01")
    private SetConfiguration setConfiguration;

  }

  @Data
  @XmlRootElement(name = "SetConfiguration")
  @XmlAccessorType(XmlAccessType.FIELD)
  @NoArgsConstructor
  @AllArgsConstructor
  public static class SetConfiguration {

    @XmlElement(name = "proxyConfiguration", namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authorization/2013/03/01")
    private ProxyConfiguration proxyConfiguration;

  }

  @Data
  @XmlRootElement(name = "ProxyConfiguration")
  @XmlAccessorType(XmlAccessType.FIELD)
  @NoArgsConstructor
  @AllArgsConstructor
  public static class ProxyConfiguration {

    @XmlElement(namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authorization/2013/03/01")
    private String id;
    @XmlElement(namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authorization/2013/03/01")
    private String name;
    @XmlElement(namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authorization/2013/03/01")
    private LocalizedName localizedName;
    @XmlElement(namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authorization/2013/03/01")
    private LocalizedDescription localizedDescription;
    @XmlElement(namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authorization/2013/03/01")
    private AuthorizationAgent authorizationAgent;

    @XmlElementWrapper(name = "guestPermissionSet", namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authorization/2013/03/01")
    @XmlElement(name= "PermissionId",namespace = "http://www.hp.com/schemas/imaging/OXPd/domain/security/2013/03/01")
    private List<String> guestPermissionSet;

    @XmlElement(namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authorization/2013/03/01")
    private Boolean addNewPermissionToGuestPermissionSet;

//    @XmlElement(name = "userPromptTarget", namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authentication/2013/03/01")
//    private UserPromptTarget userPromptTarget;

    @XmlElement(namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authorization/2013/03/01")
    private String defaultSignInMethod;
    @XmlElement(namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authorization/2013/03/01")
    private boolean enableSignInChoice;
    @XmlElement(namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authorization/2013/03/01")
    private boolean enableChangeNotification;

    @XmlElement(namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authorization/2013/03/01")
    private int changeNotificationMaxRetries;

    @XmlElement(namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authorization/2013/03/01")
    private int changeNotificationRetryInterval;


    @XmlElement(namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authorization/2013/03/01")
    private String serverContextId;

    @Data
    @XmlRootElement(name = "localizedName")
    @XmlAccessorType(XmlAccessType.FIELD)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LocalizedName {

      @XmlElement(name = "LocalizedString", namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
      private LocalizedString localizedString;

    }

    @Data
    @XmlRootElement(name = "localizedDescription")
    @XmlAccessorType(XmlAccessType.FIELD)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LocalizedDescription {

      @XmlElement(name = "LocalizedString", namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
      private LocalizedString localizedString;

    }

    @Data
    @XmlRootElement(name = "authorizationAgent")
    @XmlAccessorType(XmlAccessType.FIELD)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AuthorizationAgent {

      @XmlElement(name = "uri", namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
      private String uri;

      @XmlElement(name = "binding", namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
      private String binding;

      @XmlElement(name = "networkCredentials", namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
      private NetworkCredentials networkCredentials;

      @XmlElement(namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
      private String connectionTimeout;

      @XmlElement(namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
      private String responseTimeout;

    }

    @Data
    @XmlRootElement(name = "userPromptTarget")
    @XmlAccessorType(XmlAccessType.FIELD)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserPromptTarget {

      @XmlElement(name = "webApplication", namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
      private WebApplication webApplication;
    }


    @Data
    @XmlRootElement(name = "webApplication", namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
    @XmlAccessorType(XmlAccessType.FIELD)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class WebApplication {

      @XmlElement(namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
      private String uri;
      @XmlElement(namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
      private String binding;
      @XmlElement(name = "networkCredentials", namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
      private NetworkCredentials networkCredentials;

    }

    @Data
    @XmlRootElement(name = "LocalizedString")
    @XmlAccessorType(XmlAccessType.FIELD)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LocalizedString {

      @XmlElement(namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
      private String code;
      @XmlElement(namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
      private String value;
    }

    @Data
    @XmlRootElement(name = "networkCredential")
    @XmlAccessorType(XmlAccessType.FIELD)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class NetworkCredentials {

      @XmlElement(namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
      private String userName;
      @XmlElement(namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
      private String password;
    }

  }
}
