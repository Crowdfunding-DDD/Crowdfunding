package fr.esgi.crowdfunding.use_case.creation_compagne;

import fr.esgi.crowdfunding.model.Campagne;
import fr.esgi.crowdfunding.model.CampagneRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreationCampagne {
    private final CampagneRepository repository;
    public Campagne apply(Campagne campagne) {
        return repository.create(campagne);
    }
}
