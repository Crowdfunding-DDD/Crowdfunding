package fr.esgi.crowdfunding.model;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;


public record Investisseur(UUID id, String nom, Set<Investissement> investissements) {
    public void addInvestissement(Investissement investissement){
        investissements.add(investissement);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Investisseur that = (Investisseur) o;
        return id.equals(that.id) && Objects.equals(nom, that.nom) && investissements.equals(that.investissements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom);
    }
}
