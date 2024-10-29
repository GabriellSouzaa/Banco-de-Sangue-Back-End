package blood.bank.infra.controller;

import blood.bank.application.usecases.answer.ListAnswersByDonorFullNameAndEmailAndQuestionName;
import blood.bank.application.usecases.answer.SaveAnswer;
import blood.bank.domain.entities.answer.Answer;
import blood.bank.infra.models.requests.AnswerRequest;
import blood.bank.infra.models.responses.AnswerResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/answer")
@RestController
public class AnswerController {

    private final ListAnswersByDonorFullNameAndEmailAndQuestionName listAnswersByDonorFullNameAndEmailAndQuestionName;

    private final SaveAnswer saveAnswer;

    public AnswerController(ListAnswersByDonorFullNameAndEmailAndQuestionName listAnswersByDonorFullNameAndEmailAndQuestionName, SaveAnswer saveAnswer) {
        this.listAnswersByDonorFullNameAndEmailAndQuestionName = listAnswersByDonorFullNameAndEmailAndQuestionName;
        this.saveAnswer = saveAnswer;
    }

    @GetMapping
    public List<AnswerResponse> getAnswers(@RequestParam String donorName, @RequestParam String email, @RequestParam String questionName) {
        List<Answer> answers = listAnswersByDonorFullNameAndEmailAndQuestionName.getAnswersByDonorFullNameAndEmailAndQuestionName(donorName, email, questionName);
        return answers.stream().map(AnswerResponse::new).collect(Collectors.toList());
    }

    @PostMapping("/save-answer")
    public void saveAnswer(@RequestBody AnswerRequest answerRequest) {
        saveAnswer.saveAnswer(answerRequest);
    }
}
