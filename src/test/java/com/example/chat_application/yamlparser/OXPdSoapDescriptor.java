package com.example.chat_application.yamlparser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OXPdSoapDescriptor {

  String requestClass;
  String requestName;

  String requestAction;
  String serviceName;
}
