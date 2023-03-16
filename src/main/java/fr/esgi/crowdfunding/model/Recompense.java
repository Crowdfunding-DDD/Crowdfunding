package fr.esgi.crowdfunding.model;

import java.util.Objects;
import java.util.UUID;

public record Recompense(UUID campagneId,Double montant) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recompense that = (Recompense) o;
        return campagneId.equals(that.campagneId) && montant.equals(that.montant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(campagneId, montant);
    }

}
