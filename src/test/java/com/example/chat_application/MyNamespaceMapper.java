package com.example.chat_application;

import org.glassfish.jaxb.runtime.marshaller.NamespacePrefixMapper;

/**
 * https://dzone.com/articles/jaxb-and-namespace-prefixes
 */
public class MyNamespaceMapper extends NamespacePrefixMapper {

  private static final String FOO_PREFIX = "foo"; // DEFAULT NAMESPACE
  private static final String FOO_URI = "http://www.example.com/FOO";

  private static final String BAR_PREFIX = "bar";
  private static final String BAR_URI = "http://www.example.com/BAR";

  private static final String OTHER_PREFIX = "other";
  private static final String OTHER_URI = "http://www.example.com/OTHER";

  @Override
  public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
    if (FOO_URI.equals(namespaceUri)) {
      return FOO_PREFIX;
    } else if (BAR_URI.equals(namespaceUri)) {
      return BAR_PREFIX;
    } else if (OTHER_URI.equals(namespaceUri)) {
      return OTHER_PREFIX;
    }
    return suggestion;
  }

  @Override
  public String[] getPreDeclaredNamespaceUris() {
    return new String[]{FOO_URI, BAR_URI, OTHER_URI};
  }

}