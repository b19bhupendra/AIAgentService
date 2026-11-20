package com.aiagent.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

//- InterviewQuestionsResponse represents the complete response, containing a list of InterviewQuestion objects.
public record InterviewQuestionsResponse(
        @NotEmpty(message = "At least one question is required")
        List<@Valid InterviewQuestion> questions
) {
}
