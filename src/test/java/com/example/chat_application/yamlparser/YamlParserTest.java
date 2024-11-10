package com.example.chat_application.yamlparser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;
@SpringBootTest
public class YamlParserTest {

  @Test
  void test() throws Exception {

    OXPdSoapDescriptor yamlParser = YamlParser.parse(
        "com.hp.www.schemas.imaging.OXPd.service.accessories.HidClose");
    System.out.println(yamlParser.requestAction);
  }

  @Test
  public void whenLoadMultipleYAMLDocuments_thenLoadCorrectJavaObjects() {
    Yaml yaml = new Yaml(new Constructor(Customer.class, new LoaderOptions()));
    InputStream inputStream = this.getClass()
        .getClassLoader()
        .getResourceAsStream("src/test/resources/hp/customers.yaml");

    Customer customer = yaml.load(inputStream);
//    int count = 0;
//    for (Object object : yaml.loadAll(inputStream)) {
//      count++;
//      assertTrue(object instanceof Customer);
//    }
//    assertEquals(2, count);

  }
  @Test
  public void whenUsingYAMLBeansForSerialization_thenDeserializeCorrectMap() throws IOException {

    String filePath = "src/test/resources/hp/yamlbeans_user.yaml";

    YamlWriter writer = new YamlWriter(new FileWriter(filePath));
    writer.write(populateUserMap());
    writer.close();

    YamlReader reader = new YamlReader(new FileReader(filePath));
    Object object = reader.read();
    reader.close();

    assertTrue(object instanceof Map);
    Map<String, User> deserializedUsers = (Map<String, User>) object;

    assertEquals(4, deserializedUsers.size());
    assertEquals("Mark Jonson", (deserializedUsers.get("User1").getName()));
    assertEquals(1, (deserializedUsers.get("User1").getId()));
  }

  private Map<String, User> populateUserMap() {

    User user1 = new User();
    user1.setId(1);
    user1.setName("Mark Jonson");

    User user2 = new User();
    user2.setId(2);
    user2.setName("Johny Beth");

    User user3 = new User();
    user3.setId(3);
    user3.setName("Eliza Green");

    User user4 = new User();
    user4.setId(4);
    user4.setName("Monica Doe");

    Map<String, User> users = new LinkedHashMap<>();
    users.put("User1", user1);
    users.put("User2", user2);
    users.put("User3", user3);
    users.put("User4", user4);

    return users;
  }
}
