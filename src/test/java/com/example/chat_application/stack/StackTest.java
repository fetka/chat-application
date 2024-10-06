package com.example.chat_application.stack;

import com.example.chat_application.stack.model.RegisterOwnedAccessory;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Stack;
import javax.xml.stream.XMLStreamException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

@SpringBootTest
public class StackTest {

  @Autowired
  private ResourceLoader resourceLoader;

  @Value("classpath:hp/SetConfiguration.xml")
  private String xmlFilePath;

  @Test
  public void testWithExternalFile() throws IOException, XMLStreamException {

//    String setConfigurationXml = Files.readString(Paths.get(xmlFilePath), StandardCharsets.UTF_8);
//    System.out.println(setConfigurationXml);

    String xmlContent = loadFile("classpath:hp/SetConfiguration.xml");
    System.out.println(xmlContent);
  }

  private String loadFile(String xmlFilePath) throws IOException, XMLStreamException {
    Resource resource = resourceLoader.getResource(xmlFilePath);
    if (resource.isFile()) {
      return Files.readString(resource.getFile().toPath(), StandardCharsets.UTF_8);
    } else {
      throw new IOException("Resource is not a file: " + resource.getFilename());
    }

//    BufferedReader reader = new BufferedReader(
//        Files.newBufferedReader(resource.getFile().toPath(), StandardCharsets.UTF_8));
//    StringBuffer result = new StringBuffer();
//    try {
//      String line;
//      while ((line = reader.readLine()) != null) {
//        result.append(line.trim());
//      }
//      return result.toString();
//    } catch (IOException e) {
//      throw new RuntimeException(e);
//    }

  }

  @Test
  public void unMarshallerRegisterOwnedAccessory()
      throws JAXBException, XMLStreamException, IOException {
    JAXBContext jaxbContext = JAXBContext.newInstance(
        RegisterOwnedAccessory.class);
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    String xmlContent = loadFile("classpath:hp/RegisterOwnedAccessory.xml");
    System.out.println(xmlContent);
    RegisterOwnedAccessory envelope = (RegisterOwnedAccessory) unmarshaller.unmarshal(
        new StringReader(xmlContent));

    System.out.println(envelope);
  }

  @Test
  public void test1() {
    Stack<String> strings = new Stack<>();

    strings.push("first");
    strings.push("second");
    strings.push("fourth");
    strings.push("third");
    System.out.println(strings.size());
    System.out.println(strings.peek());
    System.out.println(strings.size());
    System.out.println(strings.peek());
  }


}
