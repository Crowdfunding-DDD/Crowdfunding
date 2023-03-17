package fr.esgi.crowdfunding.model.state;

import fr.esgi.crowdfunding.model.Campagne;

public class ClosedState implements CampagneState{
    public void moveToNextState(Campagne campagne) {
        new RuntimeException("On ne peux pas modifier l'état.");
    }
}
