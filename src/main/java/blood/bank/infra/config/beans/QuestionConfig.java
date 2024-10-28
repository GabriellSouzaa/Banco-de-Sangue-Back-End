package blood.bank.infra.config.beans;

import blood.bank.application.gateways.QuestionRepositoryGateway;
import blood.bank.application.usecases.question.ListQuestionsByQuestionaryName;
import blood.bank.infra.gateways.QuestionRepositoryJpa;
import blood.bank.infra.mappers.QuestionEntityMapper;
import blood.bank.infra.persistence.repositories.QuestionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuestionConfig {

    @Bean
    QuestionEntityMapper questionEntityMapper() {
        return new QuestionEntityMapper();
    }

    @Bean
    QuestionRepositoryJpa questionRepositoryJpa(QuestionRepository questionRepository, QuestionEntityMapper questionEntityMapper) {
        return new QuestionRepositoryJpa(questionRepository, questionEntityMapper);
    }

    @Bean
    ListQuestionsByQuestionaryName listQuestionsByQuestionaryName(QuestionRepositoryGateway questionRepositoryGateway) {
        return new ListQuestionsByQuestionaryName(questionRepositoryGateway);
    }
}
