package com.aiagent.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    //ChatClient — Spring AI abstraction for interacting with the LLM.
    private final ChatClient chatClient;

    //ChatClient.Builder — Spring AI automatically configures this using our Gemini dependency and properties.
    public ChatController(ChatClient.Builder builder){
        this.chatClient = builder.build();
    }

    //.prompt() —starts a new prompt,user(message) —supplies the user's message,call() —sends the request to Gemini,content() — extracts the generated text.
    @GetMapping("/ai/chat")
    public String chat(@RequestParam String message){
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }
}
