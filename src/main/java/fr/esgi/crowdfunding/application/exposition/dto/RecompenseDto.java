package fr.esgi.crowdfunding.application.exposition.dto;

import java.util.UUID;

public record RecompenseDto(UUID campagneId, Double montant) {
}
