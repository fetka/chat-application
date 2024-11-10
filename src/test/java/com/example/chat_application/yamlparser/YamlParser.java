package com.example.chat_application.yamlparser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import org.springframework.core.io.ResourceLoader;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

//@Service
public class YamlParser {

//  @Autowired
  private static ResourceLoader resourceLoader;
  static String yamlString;
  static Yaml yaml = new Yaml(new Constructor(OXPdSoapDescriptor.class, new LoaderOptions()));

  public static OXPdSoapDescriptor parse(String className) throws Exception {
    read();
//    String fileName = "object.yml";
//    StringBuilder contentBuilder = new StringBuilder();
//    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
//      String line;
//      while ((line = br.readLine()) != null) {
//        System.out.println(line);
//        contentBuilder.append(line).append("\n");
//
//      }
//    } catch (IOException e) {
//      System.out.println("An error occurred.");
//      e.printStackTrace();
//
//    }

//    Resource resource = new resourceLoader.getResource("classpath:hp/object.yml");
//    String content = Files.readString(resource.getFile().toPath(), StandardCharsets.UTF_8);

    Map<String, Map<String, String>> data = yaml.load(new StringReader("src/test/resources/hp/object.yml"));
//    OXPdSoapDescriptor load = (OXPdSoapDescriptor)yaml.load(new StringReader("src/test/resources/hp/object.yml"));

    Map<String, OXPdSoapDescriptor> descriptors = new HashMap<>();

    for (Map.Entry<String, Map<String, String>> entry : data.entrySet()) {
      String requestClass = entry.getKey();
      Map<String, String> serviceDetails = entry.getValue();

      OXPdSoapDescriptor descriptor = new OXPdSoapDescriptor(
          serviceDetails.get("requestClass"),
          serviceDetails.get("requestName"),
          serviceDetails.get("requestAction"),
          serviceDetails.get("serviceName")
      );
      descriptors.put(requestClass, descriptor);
    }
    return descriptors.get(className);
  }

  static String read() throws Exception {
    BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/hp/object.yml"));
    StringBuilder stringBuilder = new StringBuilder();
    String line = null;
    String ls = System.getProperty("line.separator");
    while ((line = reader.readLine()) != null) {
      stringBuilder.append(line);
      stringBuilder.append(ls);
    }
// delete the last new line separator
    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    reader.close();

    String content = stringBuilder.toString();
    System.out.println(content);
    return  content;
  }

}
