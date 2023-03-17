package fr.esgi.crowdfunding.infrastructure.repository.jpa.entities;

import fr.esgi.crowdfunding.model.CampagneStateEnum;
import fr.esgi.crowdfunding.model.CampagneTypeEnum;
import fr.esgi.crowdfunding.model.Investissement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "projects")
public class InvestissementJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "investissements_id_seq")
    @SequenceGenerator(name = "investissements_id_seq", sequenceName = "investissements_id_seq", initialValue = 1, allocationSize = 1)
    UUID id;
    Double montant;
    LocalDate date;
    @ManyToOne
    CampagneJPA campagne;
    @ManyToOne
    InvestisseurJPA investisseur;
}
