package com.example.chat_application.service;

import com.example.chat_application.model.ChatMessage;
import org.springframework.stereotype.Service;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

@Service
public class ChatService {
  public final EmitterProcessor<ChatMessage> chatProcessor = EmitterProcessor.create();
  public final FluxSink<ChatMessage> chatSink = chatProcessor.sink();

  public Flux<ChatMessage> getChatMessages() {
    return chatProcessor.publish().autoConnect();
  }

  public void sendMessage(ChatMessage message) {
    chatSink.next(message);
  }
}