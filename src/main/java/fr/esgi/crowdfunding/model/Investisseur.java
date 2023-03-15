package fr.esgi.crowdfunding.model;

import java.util.List;
import java.util.Set;
import java.util.UUID;


public record Investisseur(UUID id, String nom, Set<Campagne> investissements) {
}
