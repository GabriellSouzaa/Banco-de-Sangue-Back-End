package blood.bank.infra.controller;

import blood.bank.application.usecases.donorChallenge.GrantDonorChallenge;
import blood.bank.application.usecases.donorChallenge.ListDonorChallengeByDonorNameAndEmail;
import blood.bank.domain.entities.donorChallenge.DonorChallenge;
import blood.bank.infra.models.requests.GrantDonorChallengeRequest;
import blood.bank.infra.models.responses.DonorChallengeResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/donor-challenge")
@RestController
public class DonorChallengeController {

    private final ListDonorChallengeByDonorNameAndEmail listDonorChallengeByDonorNameAndEmail;

    private final GrantDonorChallenge grantDonorChallenge;


    public DonorChallengeController(ListDonorChallengeByDonorNameAndEmail listDonorChallengeByDonorNameAndEmail, GrantDonorChallenge grantDonorChallenge) {
        this.listDonorChallengeByDonorNameAndEmail = listDonorChallengeByDonorNameAndEmail;
        this.grantDonorChallenge = grantDonorChallenge;
    }

    @GetMapping()
    public List<DonorChallengeResponse> getDonorChallengeByDonorNameAndEmail(@RequestParam String donorName, @RequestParam String email) {
        List<DonorChallenge> donorChallenges = this.listDonorChallengeByDonorNameAndEmail.getDonorChallengeByDonorId(donorName, email);
        return donorChallenges.stream().map(DonorChallengeResponse::new).collect(Collectors.toList());
    }

    @PostMapping("/grant-donor-challenge")
    public void grantDonorChallenge(@RequestBody GrantDonorChallengeRequest grantDonorChallengeRequest){
        this.grantDonorChallenge.grantDonorChallenge(grantDonorChallengeRequest);
    }
}
