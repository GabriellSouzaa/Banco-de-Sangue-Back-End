package blood.bank.infra.controller;

import blood.bank.application.usecases.questionary.ListQuestionaries;
import blood.bank.domain.entities.questionary.Questionary;
import blood.bank.infra.models.responses.QuestionaryResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/questionary")
public class QuestionaryController {

    private final ListQuestionaries listQuestionaries;

    public QuestionaryController(ListQuestionaries listQuestionaries) {
        this.listQuestionaries = listQuestionaries;
    }

    @GetMapping
    public List<QuestionaryResponse> getQuestionaries(){
        List<Questionary> questionaries = listQuestionaries.getAllQuestionaries();
        return questionaries.stream().map(QuestionaryResponse::new).collect(Collectors.toList());
    }
}
