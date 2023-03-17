package fr.esgi.crowdfunding.exposition.mappers;



import fr.esgi.crowdfunding.exposition.dto.CampagneDto;
import fr.esgi.crowdfunding.exposition.dto.RecompenseDto;
import fr.esgi.crowdfunding.infrastructure.repository.jpa.mappers.InvestisseurJPAMapper;
import fr.esgi.crowdfunding.model.Campagne;
import fr.esgi.crowdfunding.model.Recompense;
import org.mapstruct.Builder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        builder = @Builder(disableBuilder = true),
        uses = {InvestisseurJPAMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface RecompenseDtoMapper extends GenericDtoMapper<Recompense, RecompenseDto> {
    @Mapping(target = "campagneId", source = "campagneId.id")
    RecompenseDto toDto(Recompense domain);
    @Mapping(target = "campagneId.id", source = "campagneId")
    Recompense toDomain(RecompenseDto dto);
}
