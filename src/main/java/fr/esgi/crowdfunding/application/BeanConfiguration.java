package fr.esgi.crowdfunding.application;

import fr.esgi.crowdfunding.infrastructure.repository.jpa.mappers.CampagneJPAMapper;
import fr.esgi.crowdfunding.model.CampagneRepository;
import fr.esgi.crowdfunding.model.InvestisseurRepository;
import fr.esgi.crowdfunding.use_case.creation_compagne.CreationCampagne;
import fr.esgi.crowdfunding.use_case.creation_compagne.ValidationCampagne;
import fr.esgi.crowdfunding.use_case.recompenses.CalculerRecompenses;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    CreationCampagne creationCampagne(CampagneRepository repository){
        return new CreationCampagne(repository);
    }

    @Bean
    ValidationCampagne validationCampagne(CampagneRepository repository){
        return new ValidationCampagne(repository);
    }

    @Bean
    CalculerRecompenses calculerRecompenses(InvestisseurRepository repository){
        return new CalculerRecompenses(repository);
    }
}
