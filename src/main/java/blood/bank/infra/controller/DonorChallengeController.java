package blood.bank.infra.controller;

import blood.bank.application.usecases.donorChallenge.ListDonorChallengeByDonorNameAndEmail;
import blood.bank.domain.entities.donorChallenge.DonorChallenge;
import blood.bank.infra.models.responses.DonorChallengeResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/donor-challenge")
@RestController
public class DonorChallengeController {

    private final ListDonorChallengeByDonorNameAndEmail listDonorChallengeByDonorNameAndEmail;


    public DonorChallengeController(ListDonorChallengeByDonorNameAndEmail listDonorChallengeByDonorNameAndEmail) {
        this.listDonorChallengeByDonorNameAndEmail = listDonorChallengeByDonorNameAndEmail;
    }

    @GetMapping()
    public List<DonorChallengeResponse> getDonorChallengeByDonorNameAndEmail(@RequestParam String donorName, @RequestParam String email) {
        List<DonorChallenge> donorChallenges = this.listDonorChallengeByDonorNameAndEmail.getDonorChallengeByDonorId(donorName, email);
        return donorChallenges.stream().map(DonorChallengeResponse::new).collect(Collectors.toList());
    }
}
