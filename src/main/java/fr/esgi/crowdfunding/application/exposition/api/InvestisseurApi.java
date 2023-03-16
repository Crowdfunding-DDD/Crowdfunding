package fr.esgi.crowdfunding.application.exposition.api;

import fr.esgi.crowdfunding.application.exposition.mappers.RecompenseDtoMapper;
import fr.esgi.crowdfunding.use_case.recompenses.CalculerRecompenses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/investisseur")
@RequiredArgsConstructor
@Slf4j
public class InvestisseurApi {
    private final CalculerRecompenses calculerRecompenses;
    private final RecompenseDtoMapper mapper;


    @GetMapping("/{id}/recompenses")
    public ResponseEntity<?> getAllRecompenses(@PathVariable UUID idInvestisseur){
        log.debug("Request to get investor rewards.");
        var recompenses = mapper.toDto(calculerRecompenses.apply(idInvestisseur));
        return ResponseEntity.ok(recompenses);
    }
}
