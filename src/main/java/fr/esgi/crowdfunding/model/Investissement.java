package fr.esgi.crowdfunding.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public record Investissement(UUID id, Investisseur investisseur, Campagne campagne, Double montant, LocalDate date) {
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
