package fr.esgi.crowdfunding.infrastructure.repository.jpa.entities;

import fr.esgi.crowdfunding.model.CampagneStateEnum;
import fr.esgi.crowdfunding.model.CampagneTypeEnum;
import fr.esgi.crowdfunding.model.Investissement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "projects")
public class CampagneJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "campagnes_id_seq")
    @SequenceGenerator(name = "campagnes_id_seq", sequenceName = "campagnes_id_seq", initialValue = 1, allocationSize = 1)
    UUID id;
    UUID createur;
    String nom;
    String description;
    @Enumerated(EnumType.STRING)
    CampagneTypeEnum type;
    LocalDate dateCreation;
    Double objectif;
    Set<Investissement> investissements;
    @Enumerated(EnumType.STRING)
    CampagneStateEnum etat;
    Double tauxIntret;
}
