package fr.esgi.crowdfunding.model.state;

import fr.esgi.crowdfunding.model.Campagne;

public interface CampagneState {
    void moveToNextState(Campagne campagne);
}
