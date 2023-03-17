package fr.esgi.crowdfunding.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Campagne {
    CampagneID id;
    UUID createur;
    String nom;
    String description;
    CampagneTypeEnum type;
    LocalDate dateCreation;
    Double objectif;
    Set<Investissement> investissements;
    CampagneStateEnum etat;
    Double tauxIntret;

    public CampagneStateEnum gztCampagneEtat(Campagne campagne) {
        return campagne.getEtat();
    }
}


