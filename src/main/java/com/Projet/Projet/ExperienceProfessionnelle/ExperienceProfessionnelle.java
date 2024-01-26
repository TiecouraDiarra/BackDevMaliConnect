package com.Projet.Projet.ExperienceProfessionnelle;
<<<<<<< HEAD

=======
>>>>>>> origin/Tiec
import com.Projet.Projet.utilisateur.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "experience")
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceProfessionnelle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String    datedebut;
    private String   datefin;
    private String  lieux;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private User user;

}
