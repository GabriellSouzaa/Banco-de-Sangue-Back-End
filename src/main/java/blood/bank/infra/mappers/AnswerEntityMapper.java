package blood.bank.infra.mappers;

import blood.bank.domain.entities.answer.Answer;
import blood.bank.domain.entities.donor.Donor;
import blood.bank.domain.entities.question.Question;
import blood.bank.domain.entities.questionOption.QuestionOption;
import blood.bank.infra.persistence.models.AnswerEntity;
import blood.bank.infra.persistence.models.DonorEntity;
import blood.bank.infra.persistence.models.QuestionEntity;
import blood.bank.infra.persistence.models.QuestionOptionEntity;

public class AnswerEntityMapper {

    public static AnswerEntity toEntity(Answer answer){
        DonorEntity donorEntity = DonorMapper.toEntity(answer.getDonor());
        QuestionEntity questionEntity = QuestionEntityMapper.toEntity(answer.getQuestion());
        QuestionOptionEntity questionOptionEntity = QuestionOptionEntityMapper.toEntity(answer.getOption());
        return new AnswerEntity(donorEntity, questionEntity, answer.getAnswer(), questionOptionEntity);
    }

    public static Answer toAnswer(AnswerEntity answerEntity){
        Donor donor = DonorMapper.toDonor(answerEntity.getDonor());
        Question question = QuestionEntityMapper.toQuestion(answerEntity.getQuestion());
        QuestionOption option = QuestionOptionEntityMapper.toQuestionOption(answerEntity.getOption());
        return new Answer(donor, question, answerEntity.getAnswer(), option);
    }
}
