package com.example.skilllinkbackend.shared.roledeletionhandler;

import com.example.skilllinkbackend.features.mentee.model.Mentee;
import com.example.skilllinkbackend.features.mentee.repository.IMenteeRepository;
import com.example.skilllinkbackend.features.role.model.RolesEnum;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MenteeDeletionHandler implements RoleDeletionHandler {

    private final IMenteeRepository menteeRepository;

    public MenteeDeletionHandler(IMenteeRepository menteeRepository) {
        this.menteeRepository = menteeRepository;
    }

    @Override
    public void deleteIfExistsByUserId(Long id) {
        Optional<Mentee> menteeOpt = menteeRepository.findById(id);
        menteeOpt.ifPresent(menteeRepository::delete);
    }

    @Override
    public RolesEnum supports() {
        return RolesEnum.MENTEE;
    }
}
