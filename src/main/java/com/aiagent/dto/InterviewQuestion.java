package com.aiagent.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//InterviewQuestion represents one interview question with its question, difficulty, and answer.
public record InterviewQuestion(
        @NotBlank(message = "Question cannot be empty")
        String question,
        @NotNull(message = "Difficulty is required")
        Difficulty difficulty,
        @NotBlank(message = "Answer cannot be empty")
        String answer
) {
}
