package com.example.chat_application.handler;

import com.example.chat_application.model.ChatMessage;
import com.example.chat_application.service.ChatService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class ChatWebSocketHandler extends TextWebSocketHandler {
  public final ChatService chatService;
  public final ObjectMapper objectMapper;

  public ChatWebSocketHandler(ChatService chatService, ObjectMapper objectMapper) {
    this.chatService = chatService;
    this.objectMapper = objectMapper;
  }

  @Override
  public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    String payload = message.getPayload();
    ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);

    System.out.println("ChatWebSocketHandler.handleTextMessage: " + chatMessage);
    chatService.sendMessage(chatMessage);
  }
}
