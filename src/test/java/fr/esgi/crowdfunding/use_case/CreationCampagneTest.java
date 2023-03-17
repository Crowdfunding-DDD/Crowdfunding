package fr.esgi.crowdfunding.use_case;

import fr.esgi.crowdfunding.model.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
import static fr.esgi.crowdfunding.model.CampagneTypeEnum.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CreationCampagneTest {

    @Test
    void testCreationCampagne() {
        var createurId = UUID.randomUUID();
        var campagneId = new CampagneID(UUID.randomUUID());
        var campagneNom = "Campagne 1";
        var campagneDescription = "";
        var campagneType = CROWD_EQUITY;
        var campagneDateCreation = LocalDate.of(2022, 6, 1);
        var campagneObjectif = 10000d;
        Set<Investissement> campagneInvestissements = null;
        var campagneEtat = CampagneStateEnum.DONE;
        var campagneTauxInteret = 2d;

        var campagne = new Campagne(campagneId, createurId, campagneNom, campagneDescription, campagneType, campagneDateCreation, campagneObjectif, campagneInvestissements, campagneEtat, campagneTauxInteret);

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
