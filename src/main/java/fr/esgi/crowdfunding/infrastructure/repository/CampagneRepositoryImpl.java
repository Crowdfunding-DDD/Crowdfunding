package fr.esgi.crowdfunding.infrastructure.repository;


import fr.esgi.crowdfunding.infrastructure.repository.jpa.CampagneJPARepository;
import fr.esgi.crowdfunding.infrastructure.repository.jpa.mappers.CampagneJPAMapper;
import fr.esgi.crowdfunding.model.Campagne;
import fr.esgi.crowdfunding.model.CampagneRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public record CampagneRepositoryImpl(CampagneJPARepository jpaRepository,
                                     CampagneJPAMapper mapper) implements CampagneRepository {

    @Override
    public Campagne create(Campagne campagne) {
        return mapper.toDomain(jpaRepository.save(mapper.toRepository(campagne)));
    }

    @Override
    public Campagne update(Campagne campagne) {
        return mapper.toDomain(jpaRepository.save(mapper.toRepository(campagne)));
    }

    @Override
    public Optional<Campagne> getById(UUID id) {
        return Optional.ofNullable(mapper.toDomain(jpaRepository.findById(id).orElse(null)));
    }

    @Override
    public List<Campagne> getAll(Campagne campagne) {
        return mapper.toDomain(jpaRepository.findAll());
    }
}
