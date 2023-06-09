package fr.esgi.crowdfunding.infrastructure.repository.jpa.mappers;

import fr.esgi.crowdfunding.infrastructure.repository.jpa.entities.CampagneJPA;
import fr.esgi.crowdfunding.model.Campagne;
import org.mapstruct.Builder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring",
        builder = @Builder(disableBuilder = true),
        uses = {},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
@Component
public interface CampagneJPAMapper extends GenericJPAMapper<Campagne, CampagneJPA> {
    @Mapping(source = "id.id", target = "id")
    CampagneJPA toRepository(Campagne domain);

    @Mapping(source = "id", target = "id.id")
    Campagne toDomain(CampagneJPA repository);

}
