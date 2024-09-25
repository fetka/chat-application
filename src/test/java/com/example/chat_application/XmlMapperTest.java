package com.example.chat_application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class XmlMapperTest {

  XmlMapper xmlMapper = new XmlMapper();

  @BeforeEach
  void setup() {

  }

  @Test
  public void whenJavaSerializedToXmlStr_thenCorrect() throws JsonProcessingException {
    String xml = xmlMapper.writeValueAsString(new SimpleBean());
    assertNotNull(xml);
  }

  @Test
  public void whenJavaSerializedToXmlFile_thenCorrect() throws IOException {
    xmlMapper.writeValue(new File("simple_bean.xml"), new SimpleBean());
    File file = new File("simple_bean.xml");
    assertNotNull(file);
  }

  @Test
  public void whenJavaGotFromXmlStr_thenCorrect() throws IOException {
    SimpleBean value
        = xmlMapper.readValue("<SimpleBean><x>1</x><y>2</y></SimpleBean>", SimpleBean.class);
    assertTrue(value.getX() == 1 && value.getY() == 2);
  }

  @Test
  public void whenJavaGotFromXmlFile_thenCorrect() throws IOException {
    File file = new File("simple_bean.xml");
    SimpleBean value = xmlMapper.readValue(file, SimpleBean.class);
    assertTrue(value.getX() == 2 && value.getY() == 1);
  }

  @Test
  public void whenJavaGotFromXmlStrWithCapitalElem_thenCorrect() throws IOException {

    SimpleBeanForCapitalizedFields value
        = xmlMapper.readValue(
        "<SimpleBeanForCapitalizedFields><X>1</X><y>2</y></SimpleBeanForCapitalizedFields>",
        SimpleBeanForCapitalizedFields.class);
    assertTrue(value.getX() == 1 && value.getY() == 2);
  }

  @Test
  public void whenJavaSerializedToXmlFileWithCapitalizedField_thenCorrect()
      throws IOException {
    xmlMapper.writeValue(new File("target/simple_bean_capitalized.xml"),
        new SimpleBeanForCapitalizedFields());
    File file = new File("target/simple_bean_capitalized.xml");
    assertNotNull(file);
  }

  public Person testPerson() {
    Person person = new Person();
    List<Address> addressList = Arrays.asList(new Address("Forgach", "Budapest"));
    person.setAddress(addressList);
    person.setFirstName("Andras");
    person.setLastName("Fedor");
    List<String> phoneNumbers = Arrays.asList("234324933", "24-24-24324");
    person.setPhoneNumbers(phoneNumbers);

    return person;
  }
  public static final String XML = "<Person><firstName>Andras</firstName><lastName>Fedor</lastName><phoneNumbers><phoneNumbers>234324933</phoneNumbers><phoneNumbers>24-24-24324</phoneNumbers></phoneNumbers><address><streetName>Forgach</streetName><city>Budapest</city></address></Person>";



  @Test
  public void whenJavaSerializedToXmlFile_thenSuccess() throws IOException {
    Person person = testPerson(); // test data
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    xmlMapper.writeValue(byteArrayOutputStream, person);
//    System.out.println(byteArrayOutputStream);
    assertEquals(XML, byteArrayOutputStream.toString());
  }

  @Test
  public void whenJavaDeserializedFromXmlFile_thenCorrect() throws IOException {

    Person value = xmlMapper.readValue(XML, Person.class);
    assertEquals("Budapest", value.getAddress().get(0).getCity());
//    assertEquals("City2", value.getAddress().get(1).getCity());
  }


}
