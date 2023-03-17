package fr.esgi.crowdfunding.infrastructure.repository.jpa;

import fr.esgi.crowdfunding.infrastructure.repository.jpa.entities.CampagneJPA;
import fr.esgi.crowdfunding.infrastructure.repository.jpa.entities.InvestisseurJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InvestisseurJPARepository extends JpaRepository<InvestisseurJPA, UUID> {
}
