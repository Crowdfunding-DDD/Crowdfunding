package fr.esgi.crowdfunding.model;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CampagneRepository {
    Campagne create(Campagne campagne);
    Campagne update(Campagne campagne);
    Optional<Campagne> getById(UUID id);
    List<Campagne> getAll(Campagne campagne);
}
