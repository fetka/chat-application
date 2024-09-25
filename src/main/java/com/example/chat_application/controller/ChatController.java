package com.example.chat_application.controller;

import com.example.chat_application.model.ChatMessage;
import com.example.chat_application.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
public class ChatController {
  public final ChatService chatService;

  public ChatController(ChatService chatService) {
    this.chatService = chatService;
  }

  @MessageMapping("/chat.sendMessage")
  @SendTo("/topic/public")
  public ChatMessage sendMessage(@Payload  ChatMessage chatMessage) {
    System.out.println("ChatController.sendMessage: " + chatMessage);
    chatService.sendMessage(chatMessage);
    ChatMessage response = new ChatMessage();
    response.setContent("response");
    response.setSender("server");
    return response;
  }

  @SubscribeMapping("/chat.getMessages")
  public Flux<ChatMessage> getMessages() {
    System.out.println("SubscribeMapping");
    return chatService.getChatMessages();
  }
}