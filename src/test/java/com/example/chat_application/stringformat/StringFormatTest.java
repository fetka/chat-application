package com.example.chat_application.stringformat;

import java.util.Date;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StringFormatTest {

  String soapBody =
      "<s:Envelope xmlns:s=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:a=\"http://schemas.xmlsoap.org/ws/2004/08/addressing\"><s:Header><a:Action s:mustUnderstand=\"1\">http://www.hp.com/schemas/imaging/OXPd/service/authenticationagent/2013/03/01/IAuthenticationAgentService/GetPrePromptResult</a:Action><a:MessageID>urn:uuid:af923705-951e-4ac0-bff4-6e9d2221b44e</a:MessageID><a:ReplyTo><a:Address>http://schemas.xmlsoap.org/ws/2004/08/addressing/role/anonymous</a:Address></a:ReplyTo><a:To s:mustUnderstand=\"1\">https://on-device-api.dev03.printix.dev/ws/oxpd/jackson/tenants/%s/devices/%s/preprompt</a:To></s:Header><s:Body xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"><GetPrePromptResult xmlns=\"http://www.hp.com/schemas/imaging/OXPd/service/authenticationagent/2013/03/01\"><authenticationContextId> + authContextId + </authenticationContextId> <languageCode>en-US</languageCode><serverContextId>%s<serverContextId></GetPrePromptResult></s:Body></s:Envelope>";

  @Test
  void test(){
    String namespaceS = "http://www.w3.org/2003/05/soap-envelope";
    String namespaceA = "http://schemas.xmlsoap.org/ws/2004/08/addressing";
    String action = "http://www.hp.com/schemas/imaging/OXPd/service/authenticationagent/2013/03/01/IAuthenticationAgentService/GetPrePromptResult";
    String messageId = "urn:uuid:af923705-951e-4ac0-bff4-6e9d2221b44e";
    String replyToAddress = "http://schemas.xmlsoap.org/ws/2004/08/addressing/role/anonymous";
    String toAddressTemplate = "https://on-device-api.dev03.printix.dev/ws/oxpd/jackson/tenants/%s/devices/%s/preprompt";  // Use a template for dynamic parts
    String xsiNamespace = "http://www.w3.org/2001/XMLSchema-instance";
    String xsdNamespace = "http://www.w3.org/2001/XMLSchema";
    String authContextId = "444444";  // Replace with your actual value
    String serverContextId = "333";  // Replace with your actual value

    String xmlString = String.format(
        "<s:Envelope xmlns:s=\"%s\" xmlns:a=\"%s\">" +
            "<s:Header>" +
            "<a:Action s:mustUnderstand=\"1\">%s</a:Action>" +
            "<a:MessageID>%s</a:MessageID>" +
            "<a:ReplyTo><a:Address>%s</a:Address></a:ReplyTo>" +
            "<a:To s:mustUnderstand=\"1\">%s</a:To>" +
            "</s:Header>" +
            "<s:Body xmlns:xsi=\"%s\" xmlns:xsd=\"%s\">" +
            "<GetPrePromptResult xmlns=\"http://www.hp.com/schemas/imaging/OXPd/service/authenticationagent/2013/03/01\">" +
            "<authenticationContextId>%s</authenticationContextId>" +
            "<languageCode>en-US</languageCode>" +
            "<serverContextId>%s</serverContextId>" +
            "</GetPrePromptResult>" +
            "</s:Body>" +
            "</s:Envelope>",
        namespaceS, namespaceA, action, messageId, replyToAddress, String.format(toAddressTemplate, "%s", "%s"), xsiNamespace, xsdNamespace, authContextId, serverContextId);

    System.out.println(xmlString);
  }

  @Test
  public void test1() {
    String s = String.format(soapBody, "tenantId", "printerId", "3434343434");
    System.out.println(s);

  }

}
