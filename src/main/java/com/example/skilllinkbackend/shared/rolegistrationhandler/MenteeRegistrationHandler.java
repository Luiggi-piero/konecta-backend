package com.example.skilllinkbackend.shared.rolegistrationhandler;

import com.example.skilllinkbackend.config.exceptions.BadRequestException;
import com.example.skilllinkbackend.features.mentee.dto.MenteeRegisterDTO;
import com.example.skilllinkbackend.features.mentee.model.Mentee;
import com.example.skilllinkbackend.features.mentee.repository.IMenteeRepository;
import com.example.skilllinkbackend.features.role.model.RolesEnum;
import com.example.skilllinkbackend.features.usuario.dto.UserRegisterRequestDTO;
import com.example.skilllinkbackend.features.usuario.model.User;
import org.springframework.stereotype.Component;

@Component
public class MenteeRegistrationHandler implements RoleRegistrationHandler {

    private final IMenteeRepository menteeRepository;

    public MenteeRegistrationHandler(IMenteeRepository menteeRepository) {
        this.menteeRepository = menteeRepository;
    }

    @Override
    public void handle(User user, UserRegisterRequestDTO dto) {
        MenteeRegisterDTO menteeRegisterDTO = dto.mentee();
        if (menteeRegisterDTO == null)
            throw new BadRequestException("La propiedad mentee es necesaria para el rol MENTEE");

        Mentee mentee = new Mentee(menteeRegisterDTO, user);
        menteeRepository.save(mentee);
    }

    @Override
    public RolesEnum supports() {
        return RolesEnum.MENTEE;
    }
}
