package blood.bank.infra.config.beans;

import blood.bank.application.usecases.answer.ListAnswersByDonorFullNameAndEmailAndQuestionName;
import blood.bank.infra.gateways.AnswerRepositoryJpa;
import blood.bank.infra.mappers.AnswerEntityMapper;
import blood.bank.infra.persistence.repositories.AnswerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnswerConfig {

    @Bean
    AnswerEntityMapper answerEntityMapper() {
        return new AnswerEntityMapper();
    }

    @Bean
    AnswerRepositoryJpa answerRepositoryJpa(AnswerRepository answerRepository, AnswerEntityMapper answerEntityMapper) {
        return new AnswerRepositoryJpa(answerRepository, answerEntityMapper);
    }

    @Bean
    ListAnswersByDonorFullNameAndEmailAndQuestionName listAnswersByDonorFullNameAndEmailAndQuestionName(AnswerRepositoryJpa answerRepositoryJpa) {
        return new ListAnswersByDonorFullNameAndEmailAndQuestionName(answerRepositoryJpa);
    }
}
