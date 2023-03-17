package fr.esgi.crowdfunding.exposition.mappers;


import fr.esgi.crowdfunding.exposition.dto.CampagneDto;
import fr.esgi.crowdfunding.model.Campagne;
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
