package fr.esgi.crowdfunding.use_case.recompenses;

import fr.esgi.crowdfunding.model.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;

import static fr.esgi.crowdfunding.model.CampagneStateEnum.DONE;

public class CalculerRecompenses {
    private static final Double ZERO = 0d;
    private final InvestisseurRepository investisseurRepository;

    public CalculerRecompenses(InvestisseurRepository investisseurRepository) {
        this.investisseurRepository = investisseurRepository;
    }

    public Map<UUID,Double> apply(UUID investisseurId){
        var investisseur = getInvestisseur(investisseurId);
        var recompenses = new HashMap<UUID,Double>();
        var investments = investisseur.investissements();
        investments.stream().forEach(investissement ->{
            var value = switch (investissement.campagne().type()){
                case CROWD_EQUITY -> recompenseCrowdEquity.apply(investissement);
                case CROWD_LENDING -> recompenseCrowdLending.apply(investissement);
                default -> ZERO;
            };
            recompenses.put(investissement.campagne().id(),value);
        });
        return recompenses;
    }

    private Investisseur getInvestisseur(UUID investisseurId) {
        return investisseurRepository.getById(investisseurId).orElseThrow(() -> new RuntimeException("Investisseur non trouver."));
    }

    private Function<Investissement,Double> recompenseCrowdEquity = investissement -> {
        return Objects.equals(investissement.campagne().etat(),DONE)
                ?
             investissement.montant() * investissement.campagne().tauxIntret()/100
        :
         ZERO;
    };
    private Function<Investissement,Double> recompenseCrowdLending = investissement -> {
        var nbMonths = Period.between(investissement.date(), LocalDate.now()).toTotalMonths();
        return investissement.montant() * investissement.campagne().tauxIntret() * nbMonths/ 100;
    };
}
