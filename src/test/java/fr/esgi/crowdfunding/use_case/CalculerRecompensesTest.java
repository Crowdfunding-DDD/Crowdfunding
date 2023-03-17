package fr.esgi.crowdfunding.use_case;

import fr.esgi.crowdfunding.model.*;
import fr.esgi.crowdfunding.use_case.recompenses.CalculerRecompenses;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.*;

import static fr.esgi.crowdfunding.model.CampagneTypeEnum.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CalculerRecompensesTest {
    @Mock
    private InvestisseurRepository investisseurRepository;
    private CalculerRecompenses calculerRecompenses;

    @BeforeEach
     void init() {
        MockitoAnnotations.initMocks(this);
        calculerRecompenses = new CalculerRecompenses(investisseurRepository);
    }

    @Test
     void testApply_() {
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

        List<Recompense> expectedRecompenses = new ArrayList<>();
        expectedRecompenses.add(new Recompense(campagne1.getId(), 20.0));
        expectedRecompenses.add(new Recompense(campagne2.getId(), 60.0));
        expectedRecompenses.add(new Recompense(campagne3.getId(), 0.0));

        var actualRecompenses = calculerRecompenses.apply(investisseurId);

        assertEquals(expectedRecompenses.size(), actualRecompenses.size());

        Comparator<Recompense> idComparator = Comparator.comparing(Recompense::campagneId);
        assertArrayEquals(expectedRecompenses.stream().sorted(idComparator).toArray(), actualRecompenses.stream().sorted(idComparator).toArray());
    }
}
