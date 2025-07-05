package com.example.skilllinkbackend.features.mentor.dto;

import com.example.skilllinkbackend.features.mentor.model.Mentor;
import com.example.skilllinkbackend.features.usuario.dto.UserResponseDTO;

public record MentorResponseDTO(
        Long id,
        UserResponseDTO user,
        String profession
) {
    public MentorResponseDTO(Mentor mentor) {
        this(
                mentor.getId(),
                new UserResponseDTO(mentor.getUser()),
                mentor.getProfession()
        );
    }
}
