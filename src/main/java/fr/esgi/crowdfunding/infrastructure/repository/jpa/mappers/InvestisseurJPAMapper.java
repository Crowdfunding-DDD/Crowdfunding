package fr.esgi.crowdfunding.infrastructure.repository.jpa.mappers;

import fr.esgi.crowdfunding.exposition.dto.CampagneDto;
import fr.esgi.crowdfunding.infrastructure.repository.jpa.entities.CampagneJPA;
import fr.esgi.crowdfunding.infrastructure.repository.jpa.entities.InvestisseurJPA;
import fr.esgi.crowdfunding.model.Campagne;
import fr.esgi.crowdfunding.model.Investisseur;
import org.mapstruct.Builder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",
        builder = @Builder(disableBuilder = true),
        uses = {},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)

public interface InvestisseurJPAMapper extends GenericJPAMapper<Investisseur, InvestisseurJPA> {
    @Mapping(target = "id", source = "id.id")
    InvestisseurJPA toRepository(Investisseur domain);
    @Mapping(target = "id.id", source = "id")
    Investisseur toDomain(InvestisseurJPA dto);
}
