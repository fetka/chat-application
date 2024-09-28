package com.example.chat_application.json_xml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Main {

  XmlMapper xmlMapper;
  ObjectMapper mapper;
  String xml = """
      <Person>
        <first_name>John</first_name>
        <last_name>Doe</last_name>
      </Person>
      """;
  String json = """
      {
        \"firstName\":\"John\",
        \"lastName\":\"Doe\"
      }
      """;

  public static final String RESET = "\033[0m";
  public static final String CYAN = "\033[0;36m";
  public static final String RED = "\033[0;31m";
  public static final String GREEN = "\033[0;32m";
  public static final String YELLOW = "\033[0;33m";


  @BeforeEach
  public void setup() {
    xmlMapper = new XmlMapper();
//    xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

    mapper = new ObjectMapper();
//    mapper.enable(SerializationFeature.INDENT_OUTPUT);
  }

  @Test
  public void marshalling() throws JsonProcessingException {
    System.out.println("*** marshalling test ****");

    Person person = new Person("John", "Doe");
    mapper.configure(
        com.fasterxml.jackson.databind.SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED,
        true);

    String xml = xmlMapper.writeValueAsString(person);
    System.out.println(CYAN + xml + RESET);
    System.out.println("*** end of marshalling ****\n");

    String json = mapper.writeValueAsString(person);
    System.out.println(RED + json + RESET);

  }

  @Test
  public void unmarshallingFromJSON() throws JsonProcessingException {
    System.out.println("*** unmarshallingFromJSON test  ****");
//    String json = "{\"firstName\":\"John\",\"lastName\":\"Doe\"}";
//    String myJson = "{\"lastName\":\"Kohl\",\"firstName\":\"Jurgen\"}";

    JsonMapper objectMapper = new JsonMapper();
    Person parsedObject = objectMapper.readValue(json, Person.class);
    System.out.println("parsedObject" + CYAN + parsedObject + RESET);

    String personString = xmlMapper.writeValueAsString(parsedObject);

    Person person1 = xmlMapper.readValue(personString, Person.class);
    System.out.println("personString: " + CYAN + personString + RESET);

    String s = mapper.writeValueAsString(person1);
    System.out.println("s: " + CYAN + s + RESET);
    System.out.println("*** end of unmarshallingFromJSON test ***\n");
  }

  @Test
  public void unmarshallingFromXML() throws JsonProcessingException {
    System.out.println("*** unmarshallingFromXML tests ***");
    Person person = xmlMapper.readValue(xml, Person.class);
    String s = mapper.writeValueAsString(person);

    System.out.println("s: " + CYAN + s + RESET);

    System.out.println("*** end of unmarshallingFromXML tests ***");


  }

}
