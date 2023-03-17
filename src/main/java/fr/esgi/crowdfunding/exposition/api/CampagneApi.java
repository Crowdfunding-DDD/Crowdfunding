package fr.esgi.crowdfunding.exposition.api;

import fr.esgi.crowdfunding.exposition.dto.CampagneDto;
import fr.esgi.crowdfunding.exposition.mappers.CampagneDtoMapper;
import fr.esgi.crowdfunding.model.CampagneStateEnum;
import fr.esgi.crowdfunding.use_case.creation_compagne.CreationCampagne;
import fr.esgi.crowdfunding.use_case.creation_compagne.ValidationCampagne;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/compagne")
@RequiredArgsConstructor
@Slf4j
public class CampagneApi {
    private final CreationCampagne creationCampagne;
    private final ValidationCampagne validationCampagne;
    private final CampagneDtoMapper mapper;


    @PostMapping("/{id}")
    public ResponseEntity<Void> demandeCreationCompagne(@RequestBody CampagneDto campagneDto){
        log.debug("Request to create campaign.");
        var campagne = creationCampagne.apply(mapper.toDomain(campagneDto));
        URI location = URI.create(
                ServletUriComponentsBuilder.fromCurrentRequest().build().toUri() + "/" + campagne.getId());
        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> validation(@PathVariable UUID idCampagne, @PathParam("etat") CampagneStateEnum etat){
        log.debug("Request to validate campaign.");
        validationCampagne.apply(idCampagne,etat);
        return ResponseEntity.ok().build();
    }
}
