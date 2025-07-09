package com.example.skilllinkbackend.features.project.validations.creation;

import com.example.skilllinkbackend.config.exceptions.NotFoundException;
import com.example.skilllinkbackend.features.mentee.model.Mentee;
import com.example.skilllinkbackend.features.mentee.repository.IMenteeRepository;
import com.example.skilllinkbackend.features.project.dto.ProjectRegisterDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActiveMembersValidator implements ProjectCreationValidation {

    private final IMenteeRepository menteeRepository;

    public ActiveMembersValidator(IMenteeRepository menteeRepository) {
        this.menteeRepository = menteeRepository;
    }

    @Override
    public void validate(ProjectRegisterDTO projectRegisterDTO) {
        List<Mentee> existingEmails = menteeRepository.findExistingEmails(projectRegisterDTO.members());
        boolean allExist = existingEmails.size() == projectRegisterDTO.members().size();

        if (!allExist) {
            throw new NotFoundException("Al menos un miembro del proyecto no existe, todos los miembros deben ser aprendices");
        }
    }
}
