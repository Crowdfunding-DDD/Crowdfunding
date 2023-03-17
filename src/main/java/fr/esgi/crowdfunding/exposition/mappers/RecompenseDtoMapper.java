package fr.esgi.crowdfunding.exposition.mappers;


import fr.esgi.crowdfunding.exposition.dto.RecompenseDto;
import fr.esgi.crowdfunding.model.Recompense;
import org.mapstruct.Builder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        builder = @Builder(disableBuilder = true),
        uses = {},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface RecompenseDtoMapper extends GenericDtoMapper<Recompense, RecompenseDto> {
}
