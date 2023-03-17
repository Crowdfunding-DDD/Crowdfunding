package fr.esgi.crowdfunding.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.UUID;
import java.util.function.ToDoubleFunction;

import static fr.esgi.crowdfunding.model.CampagneStateEnum.DONE;
import static fr.esgi.crowdfunding.model.CampagneTypeEnum.*;

public record Investissement(InvestissementID id, Investisseur investisseur, Campagne campagne, Double montant, LocalDate date) {
    private static final Double ZERO = 0d;

    public Double getAllRecompenses() {
        return switch (campagne().getType()) {
            case CROWD_EQUITY -> recompenseCrowdEquity();
            case CROWD_LENDING -> recompenseCrowdLending();
            default -> ZERO;
        };
    }
    private Double recompenseCrowdEquity (){
        return Objects.equals((campagne),DONE) ? montant() * campagne.getTauxIntret()/100 : ZERO;
    }


    private Double recompenseCrowdLending () {
        var nbMonths = Period.between(date, LocalDate.now()).toTotalMonths();
        return montant * campagne.getTauxIntret() * nbMonths/ 100;
    };
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Investissement that = (Investissement) o;
        return id.equals(that.id) && investisseur.equals(that.investisseur) && campagne.equals(that.campagne) && montant.equals(that.montant) && date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, investisseur, campagne, montant, date);
    }
}
