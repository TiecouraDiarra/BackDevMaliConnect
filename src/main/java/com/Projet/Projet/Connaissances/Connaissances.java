package com.Projet.Projet.Connaissances;

import com.Projet.Projet.Connaissances.TypeConnaissance.TypeConnaissances;
import com.Projet.Projet.utilisateur.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "connaissance")
@NoArgsConstructor
@AllArgsConstructor
public class Connaissances {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_typeConnaissances")
    private TypeConnaissances typeConnaissances;
}
