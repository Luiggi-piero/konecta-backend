package com.example.skilllinkbackend.shared.roledeletionhandler;

import com.example.skilllinkbackend.features.mentor.model.Mentor;
import com.example.skilllinkbackend.features.mentor.repository.IMentorRepository;
import com.example.skilllinkbackend.features.role.model.RolesEnum;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MentorDeletionHandler implements RoleDeletionHandler {

    private final IMentorRepository mentorRepository;

    public MentorDeletionHandler(IMentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    @Override
    public void deleteIfExistsByUserId(Long id) {
        Optional<Mentor> mentorOpt = mentorRepository.findById(id);
        mentorOpt.ifPresent(mentorRepository::delete);
    }

    @Override
    public RolesEnum supports() {
        return RolesEnum.MENTOR;
    }
}
