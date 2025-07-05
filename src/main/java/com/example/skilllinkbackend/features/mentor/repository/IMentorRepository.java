package com.example.skilllinkbackend.features.mentor.repository;

import com.example.skilllinkbackend.features.mentor.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMentorRepository extends JpaRepository<Mentor, Long> {
}
