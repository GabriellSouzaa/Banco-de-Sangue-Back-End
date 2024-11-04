package blood.bank.infra.controller;

import blood.bank.application.gateways.ChallengeRepositoryGateway;
import blood.bank.application.usecases.challenge.CreateChallenge;
import blood.bank.application.usecases.challenge.DeleteChallenge;
import blood.bank.application.usecases.challenge.UpdateChallenge;
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

    private final UpdateChallenge updateChallenge;

    private final DeleteChallenge deleteChallenge;

    public ChallengeController(ChallengeRepositoryGateway challengeRepositoryGateway, CreateChallenge createChallenge, UpdateChallenge updateChallenge, DeleteChallenge deleteChallenge) {
        this.challengeRepositoryGateway = challengeRepositoryGateway;
        this.createChallenge = createChallenge;
        this.updateChallenge = updateChallenge;
        this.deleteChallenge = deleteChallenge;
    }

    @GetMapping
    List<ChallengeResponse> getChallenges() {
        List<Challenge> challenges = this.challengeRepositoryGateway.getChallenges();
        return challenges.stream().map(ChallengeResponse::new).collect(Collectors.toList());
    }

    @PostMapping
    void createChallenge(@RequestBody ChallengeRequest challengeRequest){
        this.createChallenge.createChallenge(challengeRequest);
    }

    @PutMapping("/{challengeId}")
    void updateChallenge(@PathVariable Long challengeId, @RequestBody ChallengeRequest challengeRequest){
        this.updateChallenge.updateChallenge(challengeId, challengeRequest);
    }

    @DeleteMapping("/{challengeId}")
    void deleteChallenge(@PathVariable Long challengeId){
        this.deleteChallenge.deleteChallenge(challengeId);
    }
}
