package com.example.chat_application.task.authentication;


import com.example.chat_application.task.TaskAccessoryEnvelope;
import com.example.chat_application.task.authentication.TaskAuthEnvelope.Body.GetAuthenticationAgentRecordsResult;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@XmlRootElement(name = "Envelope")
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
public class RegisterAuthenticationAgentEnv {

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
    private TaskAccessoryEnvelope.Header.ReplyTo replyTo;

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

    @XmlElement(name = "RegisterAuthenticationAgent", namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authentication/2013/03/01")
    private RegisterAuthenticationAgent registerAuthenticationAgent;

  }

  @Data
  @XmlRootElement(name = "RegisterAuthenticationAgent")
  @XmlAccessorType(XmlAccessType.FIELD)
  @NoArgsConstructor
  @AllArgsConstructor
  public static class RegisterAuthenticationAgent {

    @XmlElement(name = "authenticationAgentRecord", namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authentication/2013/03/01")
    private AuthenticationAgentRecord authenticationAgentRecord;

  }

  @Data
  @XmlRootElement(name = "AuthenticationAgentRecord")
  @XmlAccessorType(XmlAccessType.FIELD)
  @NoArgsConstructor
  @AllArgsConstructor
  public static class AuthenticationAgentRecord {

    @XmlElement(namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authentication/2013/03/01")
    private String id;
    @XmlElement(namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authentication/2013/03/01")
    private String name;
    @XmlElement(namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authentication/2013/03/01")
    private GetAuthenticationAgentRecordsResult.AuthenticationAgentRecord.LocalizedName localizedName;
    @XmlElement(namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authentication/2013/03/01")
    private GetAuthenticationAgentRecordsResult.AuthenticationAgentRecord.LocalizedDescription localizedDescription;
    @XmlElement(namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authentication/2013/03/01")
    private GetAuthenticationAgentRecordsResult.AuthenticationAgentRecord.AuthenticationAgent authenticationAgent;
    @XmlElement(namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authentication/2013/03/01")
    private Boolean enablePrePromptCheck;

    @XmlElement(name = "userPromptTarget", namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authentication/2013/03/01")
    private GetAuthenticationAgentRecordsResult.AuthenticationAgentRecord.UserPromptTarget userPromptTarget;

    @XmlElement(namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authentication/2013/03/01")
    private Boolean enableSignoutNotification;
    @XmlElement(namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authentication/2013/03/01")
    private int signoutNotificationMaxRetries;
    @XmlElement(namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authentication/2013/03/01")
    private int signoutNotificationRetryInterval;
    @XmlElement(namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authentication/2013/03/01")
    private String serverContextId;

    @Data
    @XmlRootElement(name = "localizedName")
    @XmlAccessorType(XmlAccessType.FIELD)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LocalizedName {

      @XmlElement(name = "LocalizedString", namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
      private GetAuthenticationAgentRecordsResult.AuthenticationAgentRecord.LocalizedString localizedString;

    }

    @Data
    @XmlRootElement(name = "localizedDescription")
    @XmlAccessorType(XmlAccessType.FIELD)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LocalizedDescription {

      @XmlElement(name = "LocalizedString", namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
      private GetAuthenticationAgentRecordsResult.AuthenticationAgentRecord.LocalizedString localizedString;

    }

    @Data
    @XmlRootElement(name = "authenticationAgent")
    @XmlAccessorType(XmlAccessType.FIELD)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AuthenticationAgent {

      @XmlElement(name = "uri", namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
      private String uri;

      @XmlElement(name = "binding", namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
      private String binding;

      @XmlElement(name = "networkCredentials", namespace = "http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14")
      private GetAuthenticationAgentRecordsResult.AuthenticationAgentRecord.NetworkCredentials networkCredentials;

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
      private GetAuthenticationAgentRecordsResult.AuthenticationAgentRecord.WebApplication webApplication;
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
      private GetAuthenticationAgentRecordsResult.AuthenticationAgentRecord.NetworkCredentials networkCredentials;

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
