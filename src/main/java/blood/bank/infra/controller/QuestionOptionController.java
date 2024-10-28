package blood.bank.infra.controller;

import blood.bank.application.usecases.questionOption.ListQuestionsOptionsByQuestionName;
import blood.bank.domain.entities.questionOption.QuestionOption;
import blood.bank.infra.models.responses.QuestionOptionResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/question-option")
@RestController
public class QuestionOptionController {

    private final ListQuestionsOptionsByQuestionName listQuestionsOptionsByQuestionName;

    public QuestionOptionController(ListQuestionsOptionsByQuestionName listQuestionsOptionsByQuestionName) {
        this.listQuestionsOptionsByQuestionName = listQuestionsOptionsByQuestionName;
    }

    @GetMapping
    public List<QuestionOptionResponse> getQuestionsOptionsByQuestionName(@RequestParam String questionName) {
        List<QuestionOption> questionOptions = this.listQuestionsOptionsByQuestionName.getQuestionsOptionsByQuestionName(questionName);
        return questionOptions.stream().map(QuestionOptionResponse::new).collect(Collectors.toList());
    }
}
