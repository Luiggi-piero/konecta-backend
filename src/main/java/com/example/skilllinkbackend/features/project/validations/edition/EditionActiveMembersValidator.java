package com.example.skilllinkbackend.features.project.validations.edition;

import com.example.skilllinkbackend.config.exceptions.NotFoundException;
import com.example.skilllinkbackend.features.mentee.model.Mentee;
import com.example.skilllinkbackend.features.mentee.repository.IMenteeRepository;
import com.example.skilllinkbackend.features.project.dto.ProjectUpdateDTO;
import com.example.skilllinkbackend.features.usuario.model.User;
import com.example.skilllinkbackend.features.usuario.repository.IUserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EditionActiveMembersValidator implements ProjectEditionValidation {
    private final IMenteeRepository menteeRepository;

    public EditionActiveMembersValidator(IMenteeRepository menteeRepository) {
        this.menteeRepository = menteeRepository;
    }

    @Override
    public void validate(ProjectUpdateDTO projectUpdateDTO) {
        List<Mentee> existingEmails = menteeRepository.findExistingEmails(projectUpdateDTO.members());
        boolean allExist = existingEmails.size() == projectUpdateDTO.members().size();

        if (!allExist) {
            throw new NotFoundException("Al menos un miembro del proyecto no existe, todos los miembros deben ser aprendices");
        }
    }
}
