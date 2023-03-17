package fr.esgi.crowdfunding.exposition.dto;

import fr.esgi.crowdfunding.model.CampagneStateEnum;
import fr.esgi.crowdfunding.model.CampagneTypeEnum;
import fr.esgi.crowdfunding.model.Investissement;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public record CampagneDto(UUID id, UUID createur, String nom, String description, CampagneTypeEnum type,
                          LocalDate dateCreation, Double objectif, Set<Investissement> investissements,
                          CampagneStateEnum etat, Double tauxIntret)
{
}


