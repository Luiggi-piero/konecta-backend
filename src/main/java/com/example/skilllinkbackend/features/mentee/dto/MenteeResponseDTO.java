package com.example.skilllinkbackend.features.mentee.dto;

import com.example.skilllinkbackend.features.mentee.model.Mentee;
import com.example.skilllinkbackend.features.usuario.dto.UserResponseDTO;

public record MenteeResponseDTO(
        Long id,
        String phoneNumber,
        UserResponseDTO user
) {
    public MenteeResponseDTO(Mentee mentee) {
        this(
                mentee.getId(),
                mentee.getPhoneNumber(),
                new UserResponseDTO(mentee.getUser())
        );
    }
}
