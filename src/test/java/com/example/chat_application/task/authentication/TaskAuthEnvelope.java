package com.example.chat_application.task.authentication;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "Envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskAuthEnvelope {

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

    @XmlElement(name = "RelatesTo", namespace = "http://schemas.xmlsoap.org/ws/2004/08/addressing")
    private String relatesTo;

    @XmlElement(name = "To", namespace = "http://schemas.xmlsoap.org/ws/2004/08/addressing")
    private String to;

  }

  @Data
  @XmlRootElement(name = "Body")
  @XmlAccessorType(XmlAccessType.FIELD)
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Body {

    @XmlElement(name = "GetAuthenticationAgentRecordsResponse", namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authentication/2013/03/01")
    private GetAuthenticationAgentRecordsResponse getAuthenticationAgentRecordsResponse;

    @Data
    @XmlRootElement(name = "GetAuthenticationAgentRecordsResponse", namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authentication/2013/03/01")
    @XmlAccessorType(XmlAccessType.FIELD)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetAuthenticationAgentRecordsResponse {

      @XmlElement(name = "GetAuthenticationAgentRecordsResult", namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authentication/2013/03/01")
      private GetAuthenticationAgentRecordsResult getAuthenticationAgentRecordsResult;
    }

    @Data
    @XmlRootElement(name = "GetAuthenticationAgentRecordsResult")
    @XmlAccessorType(XmlAccessType.FIELD)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetAuthenticationAgentRecordsResult {

      @XmlElement(name = "AuthenticationAgentRecord", namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authentication/2013/03/01")
      private AuthenticationAgentRecord authenticationAgentRecord;

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
        private LocalizedName localizedName;
        @XmlElement(namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authentication/2013/03/01")
        private LocalizedDescription localizedDescription;
        @XmlElement(namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authentication/2013/03/01")
        private AuthenticationAgent authenticationAgent;
        @XmlElement(namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authentication/2013/03/01")
        private Boolean enablePrePromptCheck;

        @XmlElement(name = "userPromptTarget", namespace = "http://www.hp.com/schemas/imaging/OXPd/service/authentication/2013/03/01")
        private UserPromptTarget userPromptTarget;

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
  }
}
