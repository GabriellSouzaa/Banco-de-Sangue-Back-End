package blood.bank.infra.controller;

import blood.bank.application.gateways.ChallengeRepositoryGateway;
import blood.bank.domain.entities.challenge.Challenge;
import blood.bank.infra.models.responses.ChallengeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/challenge")
@RestController
public class ChallengeController {

    private final ChallengeRepositoryGateway challengeRepositoryGateway;

    public ChallengeController(ChallengeRepositoryGateway challengeRepositoryGateway) {
        this.challengeRepositoryGateway = challengeRepositoryGateway;
    }

    @GetMapping
    List<ChallengeResponse> getChallenges() {
        List<Challenge> challenges = this.challengeRepositoryGateway.getChallenges();
        return challenges.stream().map(ChallengeResponse::new).collect(Collectors.toList());
    }
}
