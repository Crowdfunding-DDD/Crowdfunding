package fr.esgi.crowdfunding.use_case.creation_compagne;

import fr.esgi.crowdfunding.model.Campagne;
import fr.esgi.crowdfunding.model.CampagneRepository;
import fr.esgi.crowdfunding.model.CampagneStateEnum;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreationCampagne {
    private final CampagneRepository repository;
    public Campagne apply(Campagne campagne) {
        campagne.setEtat(CampagneStateEnum.TO_DO);
        return repository.create(campagne);
    }
}
