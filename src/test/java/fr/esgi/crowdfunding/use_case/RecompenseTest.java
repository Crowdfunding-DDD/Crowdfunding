package fr.esgi.crowdfunding.use_case;

import fr.esgi.crowdfunding.model.*;
import fr.esgi.crowdfunding.use_case.recompenses.Recompense;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;

import static fr.esgi.crowdfunding.model.CampagneTypeEnum.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class RecompenseTest {
    @Mock
    private InvestisseurRepository investisseurRepository;
    private Recompense recompense;

    @BeforeEach
     void init() {
        MockitoAnnotations.initMocks(this);
        recompense = new Recompense(investisseurRepository);
    }

    @Test
     void testApply() {
        var investisseurId = UUID.randomUUID();
        var investisseur = new Investisseur(investisseurId,"Test",new HashSet<>());
        var campagne1 = new Campagne(UUID.randomUUID(),investisseurId,"Campagne 1","", CROWD_EQUITY, LocalDate.of(2022,6,1) ,10000d,null, CampagneStateEnum.DONE,2d);
        var campagne2 = new Campagne(UUID.randomUUID(),investisseurId,"Campagne 2","", CROWD_LENDING, LocalDate.of(2022,6,1) ,10000d,null, CampagneStateEnum.DONE,2d);
        var campagne3 = new Campagne(UUID.randomUUID(),investisseurId,"Campagne 3","", CROWD_DONATION, LocalDate.of(2022,6,1) ,10000d,null, CampagneStateEnum.DONE,2d);
        var investissement1 = new Investissement(UUID.randomUUID(), investisseur, campagne1, 1000d,LocalDate.of(2022,12,1));
        var investissement2 = new Investissement(UUID.randomUUID(), investisseur, campagne2, 1000d,LocalDate.of(2022,12,1));
        var investissement3 = new Investissement(UUID.randomUUID(), investisseur, campagne3, 1000d,LocalDate.of(2022,12,1));
        investisseur.addInvestissement(investissement1);
        investisseur.addInvestissement(investissement2);
        investisseur.addInvestissement(investissement3);

        when(investisseurRepository.getById(investisseurId)).thenReturn(java.util.Optional.of(investisseur));

        Map<UUID,Double> expectedRecompenses = new HashMap<>();
        expectedRecompenses.put(campagne1.id(), 20.0);
        expectedRecompenses.put(campagne2.id(), 60.0);
        expectedRecompenses.put(campagne3.id(), 0.0);

        var actualRecompenses = recompense.apply(investisseurId);

        assertEquals(expectedRecompenses, actualRecompenses);
    }
}
