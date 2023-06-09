package fr.esgi.crowdfunding.use_case;

import fr.esgi.crowdfunding.model.*;
import fr.esgi.crowdfunding.use_case.recompenses.CalculerRecompenses;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Calcule des récompenses pour un investisseur avec un investissement dans une campagne de type CROWD_EQUITY")
     void testApplyEquity_() {
        var investisseurId = new InvestisseurID(UUID.randomUUID());
        var investisseur = new Investisseur(investisseurId,"Test",new HashSet<>());
        var creatorId = UUID.randomUUID();
        var campagne1 = new Campagne(new CampagneID(UUID.randomUUID()),creatorId,"Campagne 1","", CROWD_EQUITY, LocalDate.of(2022,6,1) ,10000d,null, CampagneStateEnum.DONE,2d);
        var investissement1 = new Investissement(new InvestissementID(UUID.randomUUID()), investisseur, campagne1, 1000d,LocalDate.of(2022,12,1));
        investisseur.addInvestissement(investissement1);

        when(investisseurRepository.getById(investisseurId.id())).thenReturn(java.util.Optional.of(investisseur));

        List<Recompense> expectedRecompenses = new ArrayList<>();
        expectedRecompenses.add(new Recompense(campagne1.getId(), 20.0));

        var actualRecompenses = calculerRecompenses.apply(investisseurId.id());

        assertEquals(expectedRecompenses.size(), actualRecompenses.size());

        Comparator<Recompense> idComparator = Comparator.comparing(r ->r.campagneId().id());
        assertEquals(expectedRecompenses, actualRecompenses);
    }
    @Test
    @DisplayName("Calcule des récompenses pour un investisseur avec un investissement dans une campagne de type CROWD_LENDING")
    void testApplyLending_() {
        var investisseurId = new InvestisseurID(UUID.randomUUID());
        var investisseur = new Investisseur(investisseurId,"Test",new HashSet<>());
        var creatorId = UUID.randomUUID();
        var campagne2 = new Campagne(new CampagneID(UUID.randomUUID()),creatorId,"Campagne 2","", CROWD_LENDING, LocalDate.of(2022,6,1) ,10000d,null, CampagneStateEnum.DONE,2d);
        var investissement2 = new Investissement(new InvestissementID(UUID.randomUUID()), investisseur, campagne2, 1000d,LocalDate.of(2022,12,1));
        investisseur.addInvestissement(investissement2);

        when(investisseurRepository.getById(investisseurId.id())).thenReturn(java.util.Optional.of(investisseur));

        List<Recompense> expectedRecompenses = new ArrayList<>();
        expectedRecompenses.add(new Recompense(campagne2.getId(), 60.0));

        var actualRecompenses = calculerRecompenses.apply(investisseurId.id());

        assertEquals(expectedRecompenses.size(), actualRecompenses.size());

        Comparator<Recompense> idComparator = Comparator.comparing(r ->r.campagneId().id());
        assertEquals(expectedRecompenses, actualRecompenses);
    }
    @Test
    @DisplayName("Calcule des récompenses pour un investisseur avec un investissement dans une campagne de type CROWD_DONATION")
    void testApplyDonation_() {
        var investisseurId = new InvestisseurID(UUID.randomUUID());
        var investisseur = new Investisseur(investisseurId,"Test",new HashSet<>());
        var creatorId = UUID.randomUUID();
        var campagne3 = new Campagne(new CampagneID(UUID.randomUUID()),creatorId,"Campagne 3","", CROWD_DONATION, LocalDate.of(2022,6,1) ,10000d,null, CampagneStateEnum.DONE,2d);
        var investissement3 = new Investissement(new InvestissementID(UUID.randomUUID()), investisseur, campagne3, 1000d,LocalDate.of(2022,12,1));
        investisseur.addInvestissement(investissement3);

        when(investisseurRepository.getById(investisseurId.id())).thenReturn(java.util.Optional.of(investisseur));

        List<Recompense> expectedRecompenses = new ArrayList<>();
        expectedRecompenses.add(new Recompense(campagne3.getId(), 0.0));

        var actualRecompenses = calculerRecompenses.apply(investisseurId.id());

        assertEquals(expectedRecompenses.size(), actualRecompenses.size());

        Comparator<Recompense> idComparator = Comparator.comparing(r ->r.campagneId().id());
        assertEquals(expectedRecompenses, actualRecompenses);
    }
}
