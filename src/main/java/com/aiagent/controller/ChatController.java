package com.aiagent.controller;

import com.aiagent.dto.ChatRequest;
import com.aiagent.dto.InterviewQuestionsResponse;
import com.aiagent.service.ChatService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agent")
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService){
        this.chatService = chatService;
    }

    @GetMapping("/ai/chat")
    public String chat(@RequestParam String message){
        return chatService.chat(message);
    }

    //For own learning
    @PostMapping("/ai/chatV2")
    public String chatV2(@Valid @RequestBody ChatRequest chatRequest){
        return chatService.chat(chatRequest.getMessage());
    }

    @PostMapping("/ai/generate-questions")
    public InterviewQuestionsResponse generateQuestions(@Valid @RequestBody ChatRequest chatRequest){
        return chatService.generateQuestions(chatRequest.getMessage());
    }
}
