package fr.esgi.crowdfunding.infrastructure.repository.jpa.mappers;

import fr.esgi.crowdfunding.infrastructure.repository.jpa.entities.CampagneJPA;
import fr.esgi.crowdfunding.model.Campagne;
import org.mapstruct.Builder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",
        builder = @Builder(disableBuilder = true),
        uses = {},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface CampagneJPAMapper extends GenericJPAMapper<Campagne, CampagneJPA> {
}
