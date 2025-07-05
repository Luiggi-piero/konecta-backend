package com.example.skilllinkbackend.features.mentor.model;

import com.example.skilllinkbackend.features.mentor.dto.MentorRegisterDTO;
import com.example.skilllinkbackend.features.usuario.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "mentors")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mentor {

    @Id
    private Long id;

    @OneToOne
    @MapsId  // fusiona el id de la entidad Mentor con el FK que apunta a User, genera un atributo user_id que es PK y FK
    private User user;

    private String profession;

    public Mentor(MentorRegisterDTO mentorRegisterDTO, User user) {
        this.user = user;
        this.profession = mentorRegisterDTO.profession();
    }
}
