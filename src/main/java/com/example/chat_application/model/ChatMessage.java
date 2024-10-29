package com.example.chat_application.model;

import com.example.chat_application.annotation.CustomAnnotation;
import java.lang.reflect.Method;
import lombok.Data;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

@Data
public class ChatMessage {

  String sender;
  String content;

  @CustomAnnotation(value = "new content")
  public String modifyContent() throws NoSuchMethodException {
//    Class<?> clazz = ChatMessage.class;
    Method method = ChatMessage.class.getMethod("modifyContent");

    CustomAnnotation annotation = method.getAnnotation(CustomAnnotation.class);
    if (annotation != null) {
      String value = annotation.value();
      System.out.println("Annotation value: " + value);
    content = annotation.value();
    }

//    processAnnotations(CustomAnnotation.class);
    System.out.println();
    return content;
  }
  public void processAnnotations(Object obj) {
    Class<?> clazz = obj.getClass();
    CustomAnnotation annotation = clazz.getAnnotation(CustomAnnotation.class);
    if (annotation != null) {
      String value = annotation.value();
      System.out.println("Annotation value: " + value);
    }
  }
}
