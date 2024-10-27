package blood.bank.infra.controller;

import blood.bank.application.usecases.donorChallenge.ListDonorChallengeByDonorNameAndEmail;
import blood.bank.domain.entities.donorChallenge.DonorChallenge;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/donor-challenge")
@RestController
public class DonorChallengeController {

    private final ListDonorChallengeByDonorNameAndEmail listDonorChallengeByDonorNameAndEmail;


    public DonorChallengeController(ListDonorChallengeByDonorNameAndEmail listDonorChallengeByDonorNameAndEmail) {
        this.listDonorChallengeByDonorNameAndEmail = listDonorChallengeByDonorNameAndEmail;
    }

    @GetMapping()
    public List<DonorChallenge> getDonorChallengeByDonorNameAndEmail(@RequestParam String donorName, @RequestParam String email) {
        List<DonorChallenge> donorChallenges = this.listDonorChallengeByDonorNameAndEmail.getDonorChallengeByDonorId(donorName, email);
        return donorChallenges;
    }
}
