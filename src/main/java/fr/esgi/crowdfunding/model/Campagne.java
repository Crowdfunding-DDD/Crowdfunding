package fr.esgi.crowdfunding.model;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public record Campagne(UUID id, UUID createur, String nom, String description, CampagneTypeEnum type,
                       LocalDate dateCreation, Double objectif, Set<Investissement> investissements, CampagneStateEnum etat)
{

}
