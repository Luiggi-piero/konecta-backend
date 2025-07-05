package com.example.skilllinkbackend.features.mentor.dto;


import jakarta.validation.constraints.NotBlank;

public record MentorRegisterDTO(

        @NotBlank
        String profession
) {
}
