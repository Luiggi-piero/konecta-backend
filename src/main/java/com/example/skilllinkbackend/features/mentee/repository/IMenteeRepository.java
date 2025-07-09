package com.example.skilllinkbackend.features.mentee.repository;

import com.example.skilllinkbackend.features.mentee.model.Mentee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMenteeRepository extends JpaRepository<Mentee, Long> {

    @Query("""
            SELECT m
            FROM Mentee m
            WHERE m.user.email IN :emails
            AND m.user.enabled = true
            """)
    List<Mentee> findExistingEmails(List<String> emails);
}
