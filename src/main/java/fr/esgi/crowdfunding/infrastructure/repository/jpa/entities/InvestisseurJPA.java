package fr.esgi.crowdfunding.infrastructure.repository.jpa.entities;

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
public class InvestisseurJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "investisseurs_id_seq")
    @SequenceGenerator(name = "investisseurs_id_seq", sequenceName = "investisseurs_id_seq", initialValue = 1, allocationSize = 1)
    UUID id;
    String nom;
}
