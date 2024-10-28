package blood.bank.infra.controller;

import blood.bank.application.usecases.question.ListQuestionsByQuestionaryName;
import blood.bank.domain.entities.question.Question;
import blood.bank.infra.models.responses.QuestionResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/question")
@RestController
public class QuestionController {

    private final ListQuestionsByQuestionaryName listQuestionsByQuestionaryName;

    public QuestionController(ListQuestionsByQuestionaryName listQuestionsByQuestionaryName) {
        this.listQuestionsByQuestionaryName = listQuestionsByQuestionaryName;
    }

    @GetMapping
    public List<QuestionResponse> getQuestions(@RequestParam String questionaryName) {
        List<Question> questions = this.listQuestionsByQuestionaryName.getQuestionsByQuestionaryName(questionaryName);
        return questions.stream().map(QuestionResponse::new).collect(Collectors.toList());
    }
}
