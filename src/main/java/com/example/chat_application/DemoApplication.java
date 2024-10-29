package com.example.chat_application;

import com.example.chat_application.model.ChatMessage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Class<?> clazz = ChatMessage.class;
		clazz.getMethod("modifyContent");

		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setContent("old msg.");
		chatMessage.modifyContent();
		System.out.println(chatMessage.getContent());
	}
}
