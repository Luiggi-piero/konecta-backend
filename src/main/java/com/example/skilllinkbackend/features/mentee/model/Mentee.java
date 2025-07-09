package com.example.skilllinkbackend.features.mentee.model;

import com.example.skilllinkbackend.features.mentee.dto.MenteeRegisterDTO;
import com.example.skilllinkbackend.features.project.model.Project;
import com.example.skilllinkbackend.features.usuario.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "mentees")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mentee {

    @Id
    private Long id;

    @OneToOne
    @MapsId // fusiona el id de la entidad Mentee con el FK que apunta a User, genera un atributo user_user_id que es PK y FK
    private User user;

    private String phoneNumber;

    @ManyToMany(mappedBy = "members")
    private List<Project> projects;

    public Mentee(MenteeRegisterDTO menteeRegisterDTO, User user) {
        this.phoneNumber = menteeRegisterDTO.phoneNumber();
        this.user = user;
    }
}
