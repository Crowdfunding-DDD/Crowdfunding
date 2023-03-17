package fr.esgi.crowdfunding.model.state;

import fr.esgi.crowdfunding.model.Campagne;
import fr.esgi.crowdfunding.model.CampagneStateEnum;

public class ToDoState implements CampagneState {
    public void moveToNextState(Campagne campagne) {
        campagne.setEtat(CampagneStateEnum.IN_PENDING);
    }
}
