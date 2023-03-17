package fr.esgi.crowdfunding.exposition.dto;

import java.util.UUID;

public record RecompenseDto(UUID campagneId, Double montant) {
}
