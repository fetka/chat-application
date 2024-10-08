package com.example.chat_application.preprompt;

import com.example.chat_application.preprompt.GetPrePromptResultEnvelop.Body;
import com.example.chat_application.preprompt.GetPrePromptResultEnvelop.GetPrePromptResult;
import com.example.chat_application.preprompt.GetPrePromptResultEnvelop.Header;
import com.example.chat_application.preprompt.GetPrePromptResultEnvelop.Header.ReplyTo;
import com.example.chat_application.preprompt.GetPrePromptResultEnvelop.Header.To;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.junit.jupiter.api.Test;

public class PrePromptTest {

  String tenantId = "";
  String printerId = "";
  String serverContextId = "";

  String soapBody =
      "<s:Envelope xmlns:s=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:a=\"http://schemas.xmlsoap.org/ws/2004/08/addressing\"><s:Header><a:Action s:mustUnderstand=\"1\">http://www.hp.com/schemas/imaging/OXPd/service/authenticationagent/2013/03/01/IAuthenticationAgentService/GetPrePromptResult</a:Action><a:MessageID>urn:uuid:af923705-951e-4ac0-bff4-6e9d2221b44e</a:MessageID><a:ReplyTo><a:Address>http://schemas.xmlsoap.org/ws/2004/08/addressing/role/anonymous</a:Address></a:ReplyTo><a:To s:mustUnderstand=\"1\">https://on-device-api.dev03.printix.dev/ws/oxpd/jackson/tenants/"
          + tenantId + "/devices/" + printerId
          + "/preprompt</a:To></s:Header><s:Body xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"><GetPrePromptResult xmlns=\"http://www.hp.com/schemas/imaging/OXPd/service/authenticationagent/2013/03/01\"><authenticationContextId> + authContextId + </authenticationContextId> <languageCode>en-US</languageCode><serverContextId>"
          + serverContextId + "</serverContextId></GetPrePromptResult></s:Body></s:Envelope>";

  String rawData = "<s:Envelope xmlns:s=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:a=\"http://schemas.xmlsoap.org/ws/2004/08/addressing\"><s:Header><a:Action s:mustUnderstand=\"1\">http://www.hp.com/schemas/imaging/OXPd/service/authenticationagent/2013/03/01/IAuthenticationAgentService/GetPrePromptResult</a:Action><a:MessageID>urn:uuid:af923705-951e-4ac0-bff4-6e9d2221b44e</a:MessageID><a:ReplyTo><a:Address>http://schemas.xmlsoap.org/ws/2004/08/addressing/role/anonymous</a:Address></a:ReplyTo><a:To s:mustUnderstand=\"1\">https://on-device-api.dev03.printix.dev/ws/oxpd/jackson/tenants/tenantId/devices/printerId/preprompt</a:To></s:Header><s:Body xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"><GetPrePromptResult xmlns=\"http://www.hp.com/schemas/imaging/OXPd/service/authenticationagent/2013/03/01\"><authenticationContextId> + authContextId + </authenticationContextId> <languageCode>en-US</languageCode><serverContextId>serverContextId</serverContextId></GetPrePromptResult></s:Body></s:Envelope>";

  @Test
  void test02() throws JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(GetPrePromptResultEnvelop.class);
    Marshaller marshaller = jaxbContext.createMarshaller();
    GetPrePromptResultEnvelop envelop = new GetPrePromptResultEnvelop();
    Header header = new Header(
        "http://www.hp.com/schemas/imaging/OXPd/service/authenticationagent/2013/03/01/IAuthenticationAgentService",
        "message",
        new ReplyTo("http://schemas.xmlsoap.org/ws/2004/08/addressing/role/anonymous"),
        new To(1,"valuee"));

    Body body = new Body(new GetPrePromptResult("XXXX", "en-US", "XXXX"));
    envelop.setBody(body);
    envelop.setHeader(header);
    System.out.println(envelop);
    marshaller.marshal(envelop, System.out);

  }

}
