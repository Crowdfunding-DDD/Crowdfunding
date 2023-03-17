package fr.esgi.crowdfunding.infrastructure.repository.jpa.mappers;

import fr.esgi.crowdfunding.infrastructure.repository.jpa.entities.CampagneJPA;
import fr.esgi.crowdfunding.infrastructure.repository.jpa.entities.InvestissementJPA;
import fr.esgi.crowdfunding.infrastructure.repository.jpa.entities.InvestisseurJPA;
import fr.esgi.crowdfunding.model.Campagne;
import fr.esgi.crowdfunding.model.Investissement;
import fr.esgi.crowdfunding.model.Investisseur;
import org.mapstruct.Builder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",
        builder = @Builder(disableBuilder = true),
        uses = {CampagneJPAMapper.class,InvestisseurJPAMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)

public interface InvestissementJPAMapper extends GenericJPAMapper<Investissement, InvestissementJPA> {
    @Mapping(source = "id.id", target = "id")
    InvestissementJPA toRepository(Investissement domain);

    @Mapping(source = "id", target = "id.id")
    Investissement toDomain(InvestissementJPA repository);

}
