package com.aiagent.dto;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InterviewQuestionValidationTest {
    @Test
    void shouldRejectBlankQuestion() {

        try (ValidatorFactory factory =
                     Validation.buildDefaultValidatorFactory()) {

            Validator validator = factory.getValidator();

            InterviewQuestion question = new InterviewQuestion(
                    "",
                    Difficulty.INTERMEDIATE,
                    "HashMap stores key-value pairs."
            );

            var violations = validator.validate(question);

            assertFalse(violations.isEmpty());
        }
    }
}
