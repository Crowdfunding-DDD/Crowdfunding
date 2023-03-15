package fr.esgi.crowdfunding.use_case.recompenses;

import fr.esgi.crowdfunding.model.Campagne;
import fr.esgi.crowdfunding.model.CampagneRepository;

import java.util.Objects;
import java.util.function.Function;

import static fr.esgi.crowdfunding.model.CampagneStateEnum.DONE;

public class Recompense {
    private static final Double ZERO = 0d;
    private final CampagneRepository campagneRepository;

    public Recompense(CampagneRepository campagneRepository) {
        this.campagneRepository = campagneRepository;
    }

    Double apply(Campagne campagne){
        return switch (campagne.type()){
            case CROWD_EQUITY -> recompenseCrowdEquity.apply(campagne);
            case CROWD_LENDING -> recompenseCrowdLending.apply(campagne);
            default -> ZERO;
        };
    }

    private Function<Campagne,Double> recompenseCrowdEquity = campagne -> {
        if(!Objects.equals(campagne.etat(),DONE))return ZERO;
            return ZERO;
    };
    private Function<Campagne,Double> recompenseCrowdLending = campagne -> {return ZERO;};
}
