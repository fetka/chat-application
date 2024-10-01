package com.example.chat_application.task;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.StringReader;
import org.junit.jupiter.api.Test;

public class TaskMarshaller {

  @Test
  public void unMarshaller() throws JAXBException {

    String xmlString = "<env:Envelope xmlns:env=\"http://www.w3.org/2003/05/soap-envelope\">"
        + "<env:Header>"
        + "<Action>value</Action>"
        + "</env:Header>"
        + "</env:Envelope>";

    String s = " <env:Envelope xmlns:env=\"http://www.w3.org/2003/05/soap-envelope\">\n"
        + "              <Header>\n"
        + "                <n:name xmlns:n=\"http://mycompany.example.com/employees\">Fred Blogs</n:name>\n"
        + "               </Header> \n"
        + "          </env:Envelope>";

    String s2 = " <env:Envelope xmlns:env=\"http://www.w3.org/2003/05/soap-envelope\">\n"
        + "              <env:Header>\n"
        + "                <n:name xmlns:n=\"http://mycompany.example.com/employees\">Fred Blogs</n:name>\n"
        + "               </env:Header> \n"
        + "          </env:Envelope>";

    JAXBContext jaxbContext = JAXBContext.newInstance(TaskEnvelope.class);
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

    TaskEnvelope envelope = (TaskEnvelope) unmarshaller.unmarshal(new StringReader(data));

//    System.out.println(data);

    System.out.println("action:");
    System.out.println(envelope.getHeader().getAction());
    System.out.println("address:");
    System.out.println(envelope.getHeader());
    System.out.println("body:");
    System.out.println(envelope.getBody());
    System.out.println("serverContextId:");
    System.out.println(envelope.getBody().getRegisterOwnedAccessory().getOwnedAccessoryRecord()
        .getServerContextId());
  }


  @Test
  public void unMarshallerBody() throws JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(
        RegisterOwnedAccessory.class);
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

    RegisterOwnedAccessory envelope = (RegisterOwnedAccessory) unmarshaller.unmarshal(
        new StringReader(register));

    System.out.println(envelope.getOwnedAccessoryRecord().getServerContextId());
  }

  //  <?xml version= "1.0" encoding= "UTF-8"?>
  final String data = ""
      + "<env:Envelope xmlns:env= \"http://www.w3.org/2003/05/soap-envelope\">\n"
      + "    <env:Header>\n"
      + "        <Action xmlns= \"http://schemas.xmlsoap.org/ws/2004/08/addressing\" env:mustUnderstand= \"true\">\n"
      + "            http://www.hp.com/schemas/imaging/OXPd/service/accessories/2010/04/14/IAccessoriesService/RegisterOwnedAccessory</Action>\n"
      + "        <MessageID xmlns= \"http://schemas.xmlsoap.org/ws/2004/08/addressing\">uuid:ca06c8b7-49f1-412f-9865-056309226f82</MessageID>\n"
      + "        <ReplyTo xmlns= \"http://schemas.xmlsoap.org/ws/2004/08/addressing\">\n"
      + "            <Address>http://schemas.xmlsoap.org/ws/2004/08/addressing/role/anonymous</Address>\n"
      + "        </ReplyTo>\n"
      + "        <To xmlns= \"http://schemas.xmlsoap.org/ws/2004/08/addressing\" env:mustUnderstand= \"true\">\n"
      + "            https://11.153.126.166:7627/hp/device/webservices/OXPd/AccessoriesService</To>\n"
      + "    </env:Header>\n"
      + "    <env:Body>\n"
      + "        <RegisterOwnedAccessory xmlns= \"http://www.hp.com/schemas/imaging/OXPd/service/accessories/2010/04/14\" xmlns:ns2= \"http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14\">\n"
      + "            <ownedAccessoryRecord>\n"
      + "                <vendorId>65535</vendorId>\n"
      + "                <productId>53</productId>\n"
      + "                <serverContextId>45851857-81ef-447b-a8f5-428418791b67</serverContextId>\n"
      + "                <callback>\n"
      + "                    <ns2:uri>\n"
      + "                        https://on-device-api.dev03.printix.dev/ws/oxpd/jackson/tenants/9e7e155d-4c0e-4197-bb36-b9be373ad593/devices/e6a0c968-2668-42f9-a681-8eb7661a5a42/hid-event</ns2:uri>\n"
      + "                    <ns2:binding>Soap12</ns2:binding>\n"
      + "                    <ns2:networkCredentials>\n"
      + "                        <ns2:userName>e6a0c968-2668-42f9-a681-8eb7661a5a42</ns2:userName>\n"
      + "                        <ns2:password>kuzeJz6Andh6BMGkpUh8c4yLxtieLJdFm5Ep5uJjYhEFGoN3fFJ2BcPY</ns2:password>\n"
      + "                    </ns2:networkCredentials>\n"
      + "                    <ns2:connectionTimeout>60</ns2:connectionTimeout>\n"
      + "                    <ns2:responseTimeout>30</ns2:responseTimeout>\n"
      + "                </callback>\n"
      + "            </ownedAccessoryRecord>\n"
      + "        </RegisterOwnedAccessory>\n"
      + "    </env:Body>\n"
      + "</env:Envelope>";

  String register =
      "     <RegisterOwnedAccessory xmlns= \"http://www.hp.com/schemas/imaging/OXPd/service/accessories/2010/04/14\" xmlns:ns2= \"http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14\">\n"
          + "             <ownedAccessoryRecord>\n"
          + "                     <vendorId>65535</vendorId>\n"
          + "                      <productId>53</productId>\n"
          + "                      <serverContextId>45851857-81ef-447b-a8f5-428418791b67</serverContextId>\n"
          + "                     <callback>\n"
          + "                         <ns2:uri>\n"
          + "                            https://on-device-api.dev03.printix.dev/ws/oxpd/jackson/tenants/9e7e155d-4c0e-4197-bb36-b9be373ad593/devices/e6a0c968-2668-42f9-a681-8eb7661a5a42/hid-event</ns2:uri>\n"
          + "                         <ns2:binding>Soap12</ns2:binding>\n"
          + "                         <ns2:networkCredentials>\n"
          + "                           <ns2:userName>e6a0c968-2668-42f9-a681-8eb7661a5a42</ns2:userName>\n"
          + "                            <ns2:password>kuzeJz6Andh6BMGkpUh8c4yLxtieLJdFm5Ep5uJjYhEFGoN3fFJ2BcPY</ns2:password>\n"
          + "                        </ns2:networkCredentials>\n"
          + "                         <ns2:connectionTimeout>60</ns2:connectionTimeout>\n"
          + "                        <ns2:responseTimeout>30</ns2:responseTimeout>\n"
          + "                     </callback>\n"
          + "                  </ownedAccessoryRecord>\n"
          + "             </RegisterOwnedAccessory>";
}
