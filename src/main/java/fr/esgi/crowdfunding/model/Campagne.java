package fr.esgi.crowdfunding.model;

import fr.esgi.crowdfunding.model.state.CampagneState;
import fr.esgi.crowdfunding.model.state.DoneState;
import fr.esgi.crowdfunding.model.state.InPendingState;
import fr.esgi.crowdfunding.model.state.ToDoState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Campagne {
    private CampagneID id;
    private UUID createur;
    private String nom;
    private String description;
    private CampagneTypeEnum type;
    private LocalDate dateCreation;
    private Double objectif;
    private Set<Investissement> investissements;
    private CampagneStateEnum etat;
    private Double tauxIntret;
    private CampagneState currentState;

    public Campagne() {
        this.currentState = new ToDoState();
    }

    public Campagne(CampagneID campagneId, UUID createurId, String campagneNom, String campagneDescription, CampagneTypeEnum campagneType, LocalDate campagneDateCreation, double campagneObjectif, Set<Investissement> campagneInvestissements, CampagneStateEnum campagneEtat, double campagneTauxInteret) {
    this.id =campagneId;
    this.createur = createurId;
    this.nom= campagneNom;
    this.description=campagneDescription;
    this.type=campagneType;
    this.dateCreation=campagneDateCreation;
    this.objectif=campagneObjectif;
    this.investissements=campagneInvestissements;
    this.etat=campagneEtat;
    this.tauxIntret=campagneTauxInteret;
    }

    public void moveToNextState() {
        currentState.moveToNextState(this);
        switch (etat){
            case TO_DO:
                this.currentState = new InPendingState();
                break;
            case IN_PENDING:
                this.currentState = new DoneState();
                break;
            case CLOSED:
            case DONE:
                break;
            default: throw new RuntimeException();
        }
    }
}


