package fr.esgi.crowdfunding.use_case.recompenses;

import fr.esgi.crowdfunding.model.*;

import java.util.*;

public class CalculerRecompenses {
    private final InvestisseurRepository investisseurRepository;

    public CalculerRecompenses(InvestisseurRepository investisseurRepository) {
        this.investisseurRepository = investisseurRepository;
    }

    public List<Recompense> apply(UUID investisseurId){
        var investisseur = getInvestisseur(investisseurId);
        var investments = investisseur.investissements();
        return investments.stream().map(investissement -> new Recompense(investissement.campagne().getId(),investissement.getAllRecompenses())).toList();
    }

    private Investisseur getInvestisseur(UUID investisseurId) {
        return investisseurRepository.getById(investisseurId).orElseThrow(() -> new RuntimeException("Investisseur non trouver."));
    }

}
