package com.Projet.Projet.Connaissances.TypeConnaissance;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name = "typeconnaissance")
@NoArgsConstructor
@AllArgsConstructor
public class TypeConnaissances {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 200)
    private String typeConnaissances;
}
