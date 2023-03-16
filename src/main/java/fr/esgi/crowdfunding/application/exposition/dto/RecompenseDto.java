package fr.esgi.crowdfunding.application.exposition.dto;

import lombok.Getter;

import java.util.UUID;

@Getter
public record RecompenseDto(UUID campagneId, Double montant) {
}
