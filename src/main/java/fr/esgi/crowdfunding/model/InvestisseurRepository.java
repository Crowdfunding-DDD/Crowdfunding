package fr.esgi.crowdfunding.model;

import java.util.Optional;
import java.util.UUID;

public interface InvestisseurRepository {
    Optional<Investisseur> getById(UUID id);
}
