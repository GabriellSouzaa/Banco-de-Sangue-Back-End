package blood.bank.infra.config.beans;

import blood.bank.application.usecases.questionOption.ListQuestionsOptionsByQuestionName;
import blood.bank.infra.gateways.QuestionOptionRepositoryJpa;
import blood.bank.infra.mappers.QuestionOptionEntityMapper;
import blood.bank.infra.persistence.repositories.QuestionOptionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuestionOptionConfig {

    @Bean
    QuestionOptionEntityMapper questionOptionEntityMapper() {
        return new QuestionOptionEntityMapper();
    }

    @Bean
    QuestionOptionRepositoryJpa QuestionOptionRepositoryJpa(QuestionOptionRepository questionOptionRepository, QuestionOptionEntityMapper questionOptionEntityMapper) {
        return new QuestionOptionRepositoryJpa(questionOptionRepository, questionOptionEntityMapper);
    }

    @Bean
    ListQuestionsOptionsByQuestionName listQuestionsOptionsByQuestionName(QuestionOptionRepositoryJpa questionOptionRepositoryJpa) {
        return new ListQuestionsOptionsByQuestionName(questionOptionRepositoryJpa);
    }
}
