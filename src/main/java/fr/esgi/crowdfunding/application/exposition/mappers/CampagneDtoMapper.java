package fr.esgi.crowdfunding.application.exposition.mappers;


import fr.esgi.crowdfunding.application.exposition.dto.CampagneDto;
import fr.esgi.crowdfunding.application.exposition.dto.RecompenseDto;
import fr.esgi.crowdfunding.model.Campagne;
import fr.esgi.crowdfunding.model.Recompense;
import org.mapstruct.Builder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        builder = @Builder(disableBuilder = true),
        uses = {},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface CampagneDtoMapper extends GenericDtoMapper<Campagne, CampagneDto> {
}
