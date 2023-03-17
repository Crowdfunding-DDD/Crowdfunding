package fr.esgi.crowdfunding.exposition.mappers;


import fr.esgi.crowdfunding.exposition.dto.CampagneDto;
import fr.esgi.crowdfunding.model.Campagne;
import org.mapstruct.Builder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        builder = @Builder(disableBuilder = true),
        uses = {},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface CampagneDtoMapper extends GenericDtoMapper<Campagne, CampagneDto> {
    @Mapping(target = "id", source = "id.id")
    CampagneDto toDto(Campagne domain);
    @Mapping(target = "id.id", source = "id")
    Campagne toDomain(CampagneDto dto);
}
