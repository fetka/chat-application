package com.example.chat_application.certificate;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.StringReader;
import org.junit.jupiter.api.Test;

public class CertificateTest {

  String data = """
      <?xml version= \"1.0\" encoding= \"UTF-8\"?>
      <env:Envelope xmlns:env= \"http://www.w3.org/2003/05/soap-envelope\">
          <env:Header>
              <Action xmlns= \"http://schemas.xmlsoap.org/ws/2004/08/addressing\" env:mustUnderstand= \"true\">
                  http://www.hp.com/schemas/imaging/OXPd/service/certificatemanagement/2010/04/14/ICertificateManagementService/ImportCertificate</Action>
              <MessageID xmlns= \"http://schemas.xmlsoap.org/ws/2004/08/addressing\">uuid:03c7f5f1-0fdf-42a1-9610-1ff16a174955</MessageID>
              <ReplyTo xmlns= \"http://schemas.xmlsoap.org/ws/2004/08/addressing\">
                  <Address>http://schemas.xmlsoap.org/ws/2004/08/addressing/role/anonymous</Address>
              </ReplyTo>
              <To xmlns= \"http://schemas.xmlsoap.org/ws/2004/08/addressing\" env:mustUnderstand= \"true\">
                  https://163.218.131.48:7627/hp/device/webservices/OXPd/CertificateManagementService</To>
          </env:Header>
          <env:Body>
              <ImportCertificate xmlns= \"http://www.hp.com/schemas/imaging/OXPd/service/certificatemanagement/2010/04/14\">
                  <certificate>
                      MIIDSjCCAjKgAwIBAgIQRK+wgNajJ7qJMDmGLvhAazANBgkqhkiG9w0BAQUFADA/MSQwIgYDVQQKExtEaWdpdGFsIFNpZ25hdHVyZSBUcnVzdCBDby4xFzAVBgNVBAMTDkRTVCBSb290IENBIFgzMB4XDTAwMDkzMDIxMTIxOVoXDTIxMDkzMDE0MDExNVowPzEkMCIGA1UEChMbRGlnaXRhbCBTaWduYXR1cmUgVHJ1c3QgQ28uMRcwFQYDVQQDEw5EU1QgUm9vdCBDQSBYMzCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAN+v6ZdQCINXtMxiZfaQguzH0yxrMMpb7NnDfcdAwRgUi+DoM3ZJKuM/IUmTrE4Orz5Iy2Xu/NMhD2XSKtkyj4zl93ewEnu1lcCJo6m67XMuegwGMoOifooUMM0RoOEqOLl5CjH9UL2AZd+3UWODyOKIYepLYYHsUmu5ouJLGiifSKOeDNoJjj4XLh7dIN9bxiqKqy69cK3FCxolkHRyxXtqqzTWMIn/5WgTe1QLyNau7Fqckh49ZLOMxt+/yUFw7BZy1SbsOFU5Q9D8/RhcQPGX69Wam40dutolucbY38EVAjqr2m7xPi71XAicPNaDaeQQmxkqtilX4+U9m5/wAl0CAwEAAaNCMEAwDwYDVR0TAQH/BAUwAwEB/zAOBgNVHQ8BAf8EBAMCAQYwHQYDVR0OBBYEFMSnsaR7LHH62+FLkHX/xBVghYkQMA0GCSqGSIb3DQEBBQUAA4IBAQCjGiybFwBcqR7uKGY3Or+Dxz9LwwmglSBd49lZRNI+DT69ikugdB/OEIKcdBodfpga3csTS7MgROSR6cz8faXbauX+5v3gTt23ADq1cEmv8uXrAvHRAosZy5Q6XkjEGB5YGV8eAlrwDPGxrancWYaLbumR9YbK+rlmM6pZW87ipxZzR8srzJmwN0jP41ZL9c8PDHIyh8bwRLtTcm1D9SZImlJnt1ir/md2cXjbDaJWFBM5JDGFoqgCWjBH4d1QB7wCCZAA62RjYJsWvIjJEubSfZGL+T0yjWW06XyxV3bqxbYoOb8VZRzI9neWagqNdwvYkQsEjgfbKbYK7p2CNTUQ
                  </certificate>
              </ImportCertificate>
          </env:Body>
      </env:Envelope>
      """;
  String data2 = """
      <?xml version= \"1.0\" encoding= \"UTF-8\"?>
      <env:Envelope xmlns:env= \"http://www.w3.org/2003/05/soap-envelope\">
          <env:Header>
              <Action xmlns= \"http://schemas.xmlsoap.org/ws/2004/08/addressing\" env:mustUnderstand= \"true\">
                  http://www.hp.com/schemas/imaging/OXPd/service/certificatemanagement/2010/04/14/ICertificateManagementService/ImportCertificate</Action>
              <MessageID xmlns= \"http://schemas.xmlsoap.org/ws/2004/08/addressing\">uuid:03c7f5f1-0fdf-42a1-9610-1ff16a174955</MessageID>
              <ReplyTo xmlns= \"http://schemas.xmlsoap.org/ws/2004/08/addressing\">
                  <Address>http://schemas.xmlsoap.org/ws/2004/08/addressing/role/anonymous</Address>
              </ReplyTo>
              <To xmlns= \"http://schemas.xmlsoap.org/ws/2004/08/addressing\" env:mustUnderstand= \"true\">
                  https://163.218.131.48:7627/hp/device/webservices/OXPd/CertificateManagementService</To>
          </env:Header>
          <env:Body>
              <ImportCertificate xmlns= \"http://www.hp.com/schemas/imaging/OXPd/service/certificatemanagement/2010/04/14\">
                 <hell>
                 ggggggggg
                 </hell>
                  <certificate>
                     hello
                  </certificate>
              </ImportCertificate>
          </env:Body>
      </env:Envelope>
      """;

  @Test
  public void test01() throws JAXBException {
    final JAXBContext jaxbContext = JAXBContext.newInstance(
        ImportCertificatesTask.class);
    final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    ImportCertificatesTask task = (ImportCertificatesTask) unmarshaller
        .unmarshal(new StringReader(data));
    System.out.println(task);
    System.out.println(task.getBody().getImportCertificate());

  }
}
