package fr.esgi.crowdfunding.use_case.creation_compagne;

import fr.esgi.crowdfunding.model.Campagne;
import fr.esgi.crowdfunding.model.CampagneRepository;
import fr.esgi.crowdfunding.model.CampagneStateEnum;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class ValidationCampagne {
    private final CampagneRepository repository;
    public void apply(UUID idCampagne, CampagneStateEnum etat) {
        var campagne = getCampagne(idCampagne);
        campagne.setEtat(etat);
        repository.update(campagne);
    }

    private Campagne getCampagne(UUID idCampagne) {
        return repository.getById(idCampagne).orElseThrow(() -> new RuntimeException("Campagne non trouver."));
    }
}
