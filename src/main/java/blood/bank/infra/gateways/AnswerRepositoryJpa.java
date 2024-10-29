package blood.bank.infra.gateways;

import blood.bank.application.gateways.AnswerRepositoryGateway;
import blood.bank.domain.entities.answer.Answer;
import blood.bank.domain.enums.AnswerType;
import blood.bank.infra.mappers.AnswerEntityMapper;
import blood.bank.infra.models.requests.AnswerRequest;
import blood.bank.infra.persistence.models.AnswerEntity;
import blood.bank.infra.persistence.models.DonorEntity;
import blood.bank.infra.persistence.models.QuestionEntity;
import blood.bank.infra.persistence.models.QuestionOptionEntity;
import blood.bank.infra.persistence.repositories.AnswerRepository;
import blood.bank.infra.persistence.repositories.DonorRepository;
import blood.bank.infra.persistence.repositories.QuestionOptionRepository;
import blood.bank.infra.persistence.repositories.QuestionRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class AnswerRepositoryJpa  implements AnswerRepositoryGateway {

    private final AnswerRepository answerRepository;

    private final AnswerEntityMapper answerEntityMapper;

    private final QuestionRepository questionRepository;

    private final DonorRepository donorRepository;

    private final QuestionOptionRepository questionOptionRepository;

    public AnswerRepositoryJpa(AnswerRepository answerRepository, AnswerEntityMapper answerEntityMapper, QuestionRepository questionRepository, DonorRepository donorRepository, QuestionOptionRepository questionOptionRepository) {
        this.answerRepository = answerRepository;
        this.answerEntityMapper = answerEntityMapper;
        this.questionRepository = questionRepository;
        this.donorRepository = donorRepository;
        this.questionOptionRepository = questionOptionRepository;

    }

    @Override
    public List<Answer> listAnswersByDonorFullNameAndEmailAndQuestionText(String fullName, String email, String questionText) {
        List<AnswerEntity> answerEntities = answerRepository.findAnswerEntityByDonor_People_FullNameAndDonor_PeopleEmailAndQuestion_Text(fullName, email, questionText);
        return answerEntities.stream().map(AnswerEntityMapper::toAnswer).collect(Collectors.toList());
    }

    @Override
    public void saveAnswer(AnswerRequest answerRequest) {
        AnswerEntity answer = new AnswerEntity();

        DonorEntity donor = donorRepository.findById(answerRequest.getDonorId())
                .orElseThrow(() -> new EntityNotFoundException("Doador não encontrado"));

        QuestionEntity question = questionRepository.findById(answerRequest.getQuestionId())
                .orElseThrow(() -> new EntityNotFoundException("Questão não encontrada"));

        answer.setDonor(donor);
        answer.setQuestion(question);

        if(question.getType().equals(AnswerType.MULTIPLA_ESCOLHA)){
            QuestionOptionEntity option = questionOptionRepository.findById(answerRequest.getOptionId())
                    .orElseThrow(() -> new EntityNotFoundException("Alternativa não encontrada"));
            answer.setOption(option);
        } else if (question.getType().equals(AnswerType.DISSERTATIVA)){
            answer.setAnswer(answerRequest.getEssayAnswer());
        } else {
            throw new IllegalArgumentException("Tipo de Pergunta não suportado");
        }

        answerRepository.save(answer);
    }


}
