package fr.esgi.crowdfunding.infrastructure.repository;


import fr.esgi.crowdfunding.infrastructure.repository.jpa.mappers.InvestisseurJPAMapper;
import fr.esgi.crowdfunding.infrastructure.repository.jpa.InvestisseurJPARepository;
import fr.esgi.crowdfunding.model.Investisseur;
import fr.esgi.crowdfunding.model.InvestisseurRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public record InvestisseurRepositoryImpl(InvestisseurJPARepository jpaRepository,
                                         InvestisseurJPAMapper mapper) implements InvestisseurRepository {

    @Override
    public Optional<Investisseur> getById(UUID id) {
        return Optional.ofNullable(mapper.toDomain(jpaRepository.findById(id).orElse(null)));
    }

}
