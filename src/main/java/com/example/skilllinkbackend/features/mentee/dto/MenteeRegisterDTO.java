package com.example.skilllinkbackend.features.mentee.dto;

import jakarta.validation.constraints.NotBlank;

public record MenteeRegisterDTO(
        @NotBlank
        String phoneNumber
) {
}
