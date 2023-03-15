package fr.esgi.crowdfunding.model;

import java.util.UUID;

public record Investissement(UUID id,Investisseur investisseur, Campagne campagne, Double montant) {
}
