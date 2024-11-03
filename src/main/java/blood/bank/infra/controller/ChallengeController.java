package blood.bank.infra.controller;

import blood.bank.application.gateways.ChallengeRepositoryGateway;
import blood.bank.application.usecases.challenge.CreateChallenge;
import blood.bank.domain.entities.challenge.Challenge;
import blood.bank.infra.models.requests.ChallengeRequest;
import blood.bank.infra.models.responses.ChallengeResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/challenge")
@RestController
public class ChallengeController {

    private final ChallengeRepositoryGateway challengeRepositoryGateway;

    private final CreateChallenge createChallenge;

    public ChallengeController(ChallengeRepositoryGateway challengeRepositoryGateway, CreateChallenge createChallenge) {
        this.challengeRepositoryGateway = challengeRepositoryGateway;
        this.createChallenge = createChallenge;
    }

    @GetMapping
    List<ChallengeResponse> getChallenges() {
        List<Challenge> challenges = this.challengeRepositoryGateway.getChallenges();
        return challenges.stream().map(ChallengeResponse::new).collect(Collectors.toList());
    }

    @PostMapping
    void createChallenge(@RequestBody ChallengeRequest challengeRequest){
        this.challengeRepositoryGateway.createChallenge(challengeRequest);
    }
}
