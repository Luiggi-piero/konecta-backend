package com.example.skilllinkbackend.shared.rolegistrationhandler;

import com.example.skilllinkbackend.config.exceptions.BadRequestException;
import com.example.skilllinkbackend.features.mentor.dto.MentorRegisterDTO;
import com.example.skilllinkbackend.features.mentor.model.Mentor;
import com.example.skilllinkbackend.features.mentor.repository.IMentorRepository;
import com.example.skilllinkbackend.features.role.model.RolesEnum;
import com.example.skilllinkbackend.features.usuario.dto.UserRegisterRequestDTO;
import com.example.skilllinkbackend.features.usuario.model.User;
import org.springframework.stereotype.Component;

@Component
public class MentorRegistrationHandler implements RoleRegistrationHandler {

    private final IMentorRepository mentorRepository;

    public MentorRegistrationHandler(IMentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    @Override
    public void handle(User user, UserRegisterRequestDTO dto) {
        MentorRegisterDTO info = dto.mentor();
        if (info == null) throw new BadRequestException("la propiedad mentor es necesaria para el rol MENTOR");
        Mentor mentor = new Mentor(info, user);
        mentorRepository.save(mentor);
    }

    @Override
    public RolesEnum supports() {
        return RolesEnum.MENTOR;
    }
}
