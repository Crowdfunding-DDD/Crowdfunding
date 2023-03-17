package fr.esgi.crowdfunding.use_case;

import fr.esgi.crowdfunding.model.*;
import fr.esgi.crowdfunding.use_case.creation_compagne.CreationCampagne;
import fr.esgi.crowdfunding.use_case.recompenses.CalculerRecompenses;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
import static fr.esgi.crowdfunding.model.CampagneTypeEnum.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CreationCampagneTest {
    @Mock
    private CampagneRepository campagneRepository;
    private CreationCampagne creationCampagne;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
        creationCampagne = new CreationCampagne(campagneRepository);
    }

    @Test
    @DisplayName("Création d'une campagne")
    void testCreationCampagne() {
        var createurId = UUID.randomUUID();
        var campagneId = new CampagneID(UUID.randomUUID());
        var campagneNom = "Campagne 1";
        var campagneDescription = "";
        var campagneType = CROWD_EQUITY;
        var campagneDateCreation = LocalDate.of(2022, 6, 1);
        var campagneObjectif = 10000d;
        Set<Investissement> campagneInvestissements = null;
        var campagneEtat = CampagneStateEnum.IN_PENDING;
        var campagneTauxInteret = 2d;

        var campagne = new Campagne(campagneId, createurId, campagneNom, campagneDescription, campagneType, campagneDateCreation, campagneObjectif, campagneInvestissements, campagneEtat, campagneTauxInteret);
        creationCampagne.apply(campagne);

        assertEquals(campagneId, campagne.getId());
        assertEquals(createurId, campagne.getCreateur());
        assertEquals(campagneNom, campagne.getNom());
        assertEquals(campagneDescription, campagne.getDescription());
        assertEquals(campagneType, campagne.getType());
        assertEquals(campagneDateCreation, campagne.getDateCreation());
        assertEquals(campagneObjectif, campagne.getObjectif());
        assertNull(campagne.getInvestissements());
        assertEquals(campagneEtat, campagne.getEtat());
        assertEquals(campagneTauxInteret, campagne.getTauxInteret());
    }
}
