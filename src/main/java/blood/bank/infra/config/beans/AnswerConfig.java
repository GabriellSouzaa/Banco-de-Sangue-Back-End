package blood.bank.infra.config.beans;

import blood.bank.application.usecases.answer.ListAnswersByDonorFullNameAndEmailAndQuestionName;
import blood.bank.application.usecases.answer.SaveAnswer;
import blood.bank.infra.gateways.AnswerRepositoryJpa;
import blood.bank.infra.mappers.AnswerEntityMapper;
import blood.bank.infra.persistence.repositories.AnswerRepository;
import blood.bank.infra.persistence.repositories.DonorRepository;
import blood.bank.infra.persistence.repositories.QuestionOptionRepository;
import blood.bank.infra.persistence.repositories.QuestionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnswerConfig {

    @Bean
    AnswerEntityMapper answerEntityMapper() {
        return new AnswerEntityMapper();
    }

    @Bean
    AnswerRepositoryJpa answerRepositoryJpa(AnswerRepository answerRepository, AnswerEntityMapper answerEntityMapper, QuestionRepository questionRepository, DonorRepository donorRepository, QuestionOptionRepository questionOptionRepository) {
        return new AnswerRepositoryJpa(answerRepository, answerEntityMapper, questionRepository, donorRepository, questionOptionRepository);
    }

    @Bean
    ListAnswersByDonorFullNameAndEmailAndQuestionName listAnswersByDonorFullNameAndEmailAndQuestionName(AnswerRepositoryJpa answerRepositoryJpa) {
        return new ListAnswersByDonorFullNameAndEmailAndQuestionName(answerRepositoryJpa);
    }

    @Bean
    SaveAnswer saveAnswer(AnswerRepositoryJpa answerRepositoryJpa) {
        return new SaveAnswer(answerRepositoryJpa);
    }
}
