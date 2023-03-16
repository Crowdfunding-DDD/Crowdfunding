package fr.esgi.crowdfunding.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.UUID;
import java.util.function.ToDoubleFunction;

import static fr.esgi.crowdfunding.model.CampagneStateEnum.DONE;

public record Investissement(UUID id, Investisseur investisseur, Campagne campagne, Double montant, LocalDate date) {
    private static final Double ZERO = 0d;

    public Double getAllRecompenses() {
        return switch (campagne().type()) {
            case CROWD_EQUITY -> recompenseCrowdEquity.applyAsDouble(this);
            case CROWD_LENDING -> recompenseCrowdLending.applyAsDouble(this);
            default -> ZERO;
        };
    }
    private static ToDoubleFunction<Investissement> recompenseCrowdEquity = investissement ->
            Objects.equals(investissement.campagne().etat(),DONE) ? investissement.montant() * investissement.campagne().tauxIntret()/100 : ZERO;
    private static ToDoubleFunction<Investissement> recompenseCrowdLending = investissement -> {
        var nbMonths = Period.between(investissement.date(), LocalDate.now()).toTotalMonths();
        return investissement.montant() * investissement.campagne().tauxIntret() * nbMonths/ 100;
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
