package fr.esgi.crowdfunding.infrastructure.repository.jpa;

import fr.esgi.crowdfunding.infrastructure.repository.jpa.entities.CampagneJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CampagneJPARepository extends JpaRepository<CampagneJPA, UUID> {
}
