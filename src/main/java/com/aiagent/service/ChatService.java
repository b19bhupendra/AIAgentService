package com.aiagent.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    //ChatClient — Spring AI abstraction for interacting with the LLM.
    private final ChatClient chatClient;

    //ChatClient.Builder — Spring AI automatically configures this using our Gemini dependency and properties.
    public ChatService(ChatClient.Builder builder){
        this.chatClient = builder.build();
    }



    public String chat(String message){
        //.prompt() —starts a new prompt,user(message) —supplies the user's message,call() —sends the request to Gemini,content() — extracts the generated text.
        return chatClient.prompt()
                // System message: Defines AI behaviour
                .system("""
                        You are an experienced Java technical interviewer.

                        Your responsibilities:
                        1. Generate technically accurate Java interview questions.
                        2. Keep explanations simple and clear.
                        3. Avoid duplicate questions.
                        4. Adjust difficulty according to the candidate's experience.
                        5. Focus on backend Java development topics.
                        """)
                // User message: Actual request
                .user(message)
                //send req to gemini
                .call()
                //Extract response
                .content();

    }
}
