package blood.bank.infra.config.beans;

import blood.bank.application.gateways.QuestionaryRepositoryGateway;
import blood.bank.application.usecases.questionary.ListQuestionaries;
import blood.bank.infra.gateways.QuestionaryRepositoryJpa;
import blood.bank.infra.mappers.QuestionaryEntityMapper;
import blood.bank.infra.persistence.repositories.QuestionaryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuestionaryConfig {

    @Bean
    QuestionaryEntityMapper questionaryEntityMapper() {
        return new QuestionaryEntityMapper();
    }

    @Bean
    QuestionaryRepositoryJpa questionaryRepositoryJpa(QuestionaryRepository questionaryRepository, QuestionaryEntityMapper questionaryEntityMapper) {
        return new QuestionaryRepositoryJpa(questionaryRepository, questionaryEntityMapper);
    }

    @Bean
    ListQuestionaries listQuestionaries(QuestionaryRepositoryGateway questionaryRepositoryGateway){
        return new ListQuestionaries(questionaryRepositoryGateway);
    }
}
