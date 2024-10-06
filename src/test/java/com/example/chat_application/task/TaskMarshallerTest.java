package com.example.chat_application.task;

import com.example.chat_application.task.authentication.TaskAuthEnvelope;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import org.junit.jupiter.api.Test;

public class TaskMarshallerTest {

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

    JAXBContext jaxbContext = JAXBContext.newInstance(TaskAccessoryEnvelope.class);
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

    TaskAccessoryEnvelope envelope = (TaskAccessoryEnvelope) unmarshaller.unmarshal(
        new StringReader(data));

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


  @Test
  public void unMarshallerTaskAuth() throws JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(
        TaskAuthEnvelope.class);
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

    TaskAuthEnvelope envelope = (TaskAuthEnvelope) unmarshaller.unmarshal(
        new StringReader(oneLineAuthResponse));

    System.out.println("header:");
    System.out.println(envelope.getHeader());
    System.out.println("body:");
    System.out.println(envelope.getBody());

    envelope.getBody().getGetAuthenticationAgentRecordsResponse()
        .getGetAuthenticationAgentRecordsResult().getAuthenticationAgentRecord()
        .setServerContextId("44444444444444");
    System.out.println(envelope.getBody());

    JAXBContext jaxbContext2 = JAXBContext.newInstance(TaskAuthEnvelope.class);
    Marshaller marshaller = jaxbContext2.createMarshaller();
    System.out.println("********************************");
//    marshaller.marshal(envelope, System.out);

    // Marshal the object to a String
    StringWriter stringWriter = new StringWriter();
    marshaller.marshal(envelope, stringWriter);
    String xmlString = stringWriter.toString().replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", "");

    System.out.println(xmlString);

  }

  @Test
  public void marshallerTaskAuth() throws JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(TaskAuthEnvelope.class);
    Marshaller marshaller = jaxbContext.createMarshaller();
    TaskAuthEnvelope envelope = new TaskAuthEnvelope();

    System.out.println("header:");
    System.out.println(envelope.getHeader());
    System.out.println("body:");
    System.out.println(envelope.getBody());
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


  String oneLineAuthResponse = "<s:Envelope xmlns:s= \"http://www.w3.org/2003/05/soap-envelope\" xmlns:a= \"http://schemas.xmlsoap.org/ws/2004/08/addressing\"><s:Header><a:Action s:mustUnderstand= \"1\">http://www.hp.com/schemas/imaging/OXPd/service/authentication/2013/03/01/IAuthenticationService/GetAuthenticationAgentRecords</a:Action><a:RelatesTo>uuid:954a2122-1ddd-471a-a048-46af6ba7ac02</a:RelatesTo><a:To s:mustUnderstand= \"1\">http://schemas.xmlsoap.org/ws/2004/08/addressing/role/anonymous</a:To></s:Header><s:Body xmlns:xsi= \"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd= \"http://www.w3.org/2001/XMLSchema\"><GetAuthenticationAgentRecordsResponse xmlns= \"http://www.hp.com/schemas/imaging/OXPd/service/authentication/2013/03/01\"><GetAuthenticationAgentRecordsResult><AuthenticationAgentRecord><id>9941eaac-0c3e-4b52-b394-f93a3a734174</id><name>Printix</name><localizedName><LocalizedString xmlns= \"http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14\"><code>en-US</code><value>Printix</value></LocalizedString></localizedName><localizedDescription><LocalizedString xmlns= \"http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14\"><code>en-US</code><value>Printix Authentication Agent</value></LocalizedString></localizedDescription><authenticationAgent><uri xmlns= \"http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14\">https://on-device-api.dev03.printix.dev/ws/oxpd/jackson/tenants/7202fac2-ccc8-4990-a4dc-da3cc19cdc8a/devices/6453c9f0-d529-4302-96e0-4d44b8b43f27/preprompt</uri><binding xmlns= \"http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14\">Soap12</binding><networkCredentials xmlns= \"http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14\"><userName>6453c9f0-d529-4302-96e0-4d44b8b43f27</userName><password>u1JGUZgwAyHYrwqK8APEMglurvHdCSqAI9RnLxbrB036qFbiyfwybEb3</password></networkCredentials><connectionTimeout xmlns= \"http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14\">60</connectionTimeout><responseTimeout xmlns= \"http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14\">60</responseTimeout></authenticationAgent><enablePrePromptCheck>true</enablePrePromptCheck><userPromptTarget><webApplication xmlns= \"http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14\"><uri>https://on-device-api.dev03.printix.dev/ws/oxpd/jackson/tenants/7202fac2-ccc8-4990-a4dc-da3cc19cdc8a/devices/6453c9f0-d529-4302-96e0-4d44b8b43f27/signin/index.html</uri><binding>Plain</binding><networkCredentials><userName>6453c9f0-d529-4302-96e0-4d44b8b43f27</userName><password>u1JGUZgwAyHYrwqK8APEMglurvHdCSqAI9RnLxbrB036qFbiyfwybEb3</password></networkCredentials></webApplication></userPromptTarget><enableSignoutNotification>true</enableSignoutNotification><signoutNotificationMaxRetries>3</signoutNotificationMaxRetries><signoutNotificationRetryInterval>3</signoutNotificationRetryInterval><serverContextId>08a86a7b-acbf-4002-b4a2-cfd858dd1b58</serverContextId></AuthenticationAgentRecord></GetAuthenticationAgentRecordsResult></GetAuthenticationAgentRecordsResponse></s:Body></s:Envelope>";
  String authResponse =
      "<s:Envelope xmlns:s= \"http://www.w3.org/2003/05/soap-envelope\" xmlns:a= \"http://schemas.xmlsoap.org/ws/2004/08/addressing\">\n"
          + "    <s:Header>\n"
          + "        <a:Action s:mustUnderstand= \"1\">\n"
          + "            http://www.hp.com/schemas/imaging/OXPd/service/authentication/2013/03/01/IAuthenticationService/GetAuthenticationAgentRecords</a:Action>\n"
          + "        <a:RelatesTo>uuid:954a2122-1ddd-471a-a048-46af6ba7ac02</a:RelatesTo>\n"
          + "        <a:To s:mustUnderstand= \"1\">http://schemas.xmlsoap.org/ws/2004/08/addressing/role/anonymous</a:To>\n"
          + "    </s:Header>"
          + "    <s:Body xmlns:xsi= \"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd= \"http://www.w3.org/2001/XMLSchema\">\n"
          + "        <GetAuthenticationAgentRecordsResponse xmlns= \"http://www.hp.com/schemas/imaging/OXPd/service/authentication/2013/03/01\">\n"
          + "            <GetAuthenticationAgentRecordsResult>\n"
          + "                <AuthenticationAgentRecord>\n"
          + "                    <id>9941eaac-0c3e-4b52-b394-f93a3a734174</id>\n"
          + "                    <name>Printix</name>\n"
          + "                    <localizedName>\n"
          + "                        <LocalizedString xmlns= \"http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14\">\n"
          + "                            <code>en-US</code>\n"
          + "                            <value>Printix</value>\n"
          + "                        </LocalizedString>\n"
          + "                    </localizedName>\n"
          + "                    <localizedDescription>\n"
          + "                        <LocalizedString xmlns= \"http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14\">\n"
          + "                            <code>en-US</code>\n"
          + "                            <value>Printix Authentication Agent</value>\n"
          + "                        </LocalizedString>\n"
          + "                    </localizedDescription>\n"
          + "                    <authenticationAgent>\n"
          + "                        <uri xmlns= \"http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14\">\n"
          + "                            https://on-device-api.dev03.printix.dev/ws/oxpd/jackson/tenants/7202fac2-ccc8-4990-a4dc-da3cc19cdc8a/devices/6453c9f0-d529-4302-96e0-4d44b8b43f27/preprompt</uri>\n"
          + "                        <binding xmlns= \"http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14\">Soap12</binding>\n"
          + "                        <networkCredentials xmlns= \"http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14\">\n"
          + "                            <userName>6453c9f0-d529-4302-96e0-4d44b8b43f27</userName>\n"
          + "                            <password>u1JGUZgwAyHYrwqK8APEMglurvHdCSqAI9RnLxbrB036qFbiyfwybEb3</password>\n"
          + "                        </networkCredentials>\n"
          + "                        <connectionTimeout xmlns= \"http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14\">60</connectionTimeout>\n"
          + "                        <responseTimeout xmlns= \"http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14\">60</responseTimeout>\n"
          + "                    </authenticationAgent>\n"
          + "                    <enablePrePromptCheck>true</enablePrePromptCheck>\n"
          + "                    <userPromptTarget>\n"
          + "                        <webApplication xmlns= \"http://www.hp.com/schemas/imaging/OXPd/common/2010/04/14\">\n"
          + "                            <uri>\n"
          + "                                https://on-device-api.dev03.printix.dev/ws/oxpd/jackson/tenants/7202fac2-ccc8-4990-a4dc-da3cc19cdc8a/devices/6453c9f0-d529-4302-96e0-4d44b8b43f27/signin/index.html</uri>\n"
          + "                            <binding>Plain</binding>\n"
          + "                            <networkCredentials>\n"
          + "                                <userName>6453c9f0-d529-4302-96e0-4d44b8b43f27</userName>\n"
          + "                                <password>u1JGUZgwAyHYrwqK8APEMglurvHdCSqAI9RnLxbrB036qFbiyfwybEb3</password>\n"
          + "                            </networkCredentials>\n"
          + "                        </webApplication>\n"
          + "                    </userPromptTarget>\n"
          + "                    <enableSignoutNotification>true</enableSignoutNotification>\n"
          + "                    <signoutNotificationMaxRetries>3</signoutNotificationMaxRetries>\n"
          + "                    <signoutNotificationRetryInterval>3</signoutNotificationRetryInterval>\n"
          + "                    <serverContextId>08a86a7b-acbf-4002-b4a2-cfd858dd1b58</serverContextId>\n"
          + "                </AuthenticationAgentRecord>\n"
          + "            </GetAuthenticationAgentRecordsResult>\n"
          + "        </GetAuthenticationAgentRecordsResponse>"
          + "</s:Body>"
          + "</s:Envelope>";
}
