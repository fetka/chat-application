package com.example.chat_application.example;

import java.util.HashMap;
import java.util.Map;
import org.glassfish.jaxb.runtime.marshaller.NamespacePrefixMapper;

public class MyNamespaceMapperByGemini extends NamespacePrefixMapper {

  private static final Map<String, String> prefixMap = new HashMap<>();

  static {
    prefixMap.put("http://www.example.com/FOO", "gemini");
    prefixMap.put("http://www.example.com/BAR", "bar");
    prefixMap.put("http://www.example.com/OTHER", "other");
  }

  @Override
  public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
    if (prefixMap.containsKey(namespaceUri)) {
//      return
//          suggestion == null || suggestion.isEmpty() && "".equals(namespaceUri) ? ""
//              : prefixMap.get(namespaceUri);
      return prefixMap.get(namespaceUri);
    } else if (requirePrefix) {
      throw new IllegalArgumentException("Unknown namespace URI: " + namespaceUri);
    }
    return suggestion;
  }

  @Override
  public String[] getPreDeclaredNamespaceUris() {
    return prefixMap.keySet().toArray(new String[0]);
  }
}
