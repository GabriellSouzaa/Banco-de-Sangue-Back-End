package blood.bank.infra.controller;

import blood.bank.application.usecases.donorReward.GrantDonorReward;
import blood.bank.application.usecases.donorReward.ListDonorsRewardByDonorId;
import blood.bank.domain.entities.donorReward.DonorReward;
import blood.bank.infra.models.requests.GrantDonorRewardRequest;
import blood.bank.infra.models.responses.DonorRewardResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/donor-reward")
@RestController
public class DonorRewardController {

    private final ListDonorsRewardByDonorId listDonorsRewardByDonorId;

    private final GrantDonorReward grantDonorReward;

    public DonorRewardController(ListDonorsRewardByDonorId listDonorsRewardByDonorId, GrantDonorReward grantDonorReward) {
        this.listDonorsRewardByDonorId = listDonorsRewardByDonorId;
        this.grantDonorReward = grantDonorReward;
    }

    @GetMapping("/donor/{donorId}")
    public List<DonorRewardResponse> getDonorRewardByDonorId(@PathVariable Long donorId) {
        List<DonorReward> donorRewards = listDonorsRewardByDonorId.getDonorsRewardByDonorId(donorId);
        return donorRewards.stream().map(DonorRewardResponse::new).collect(java.util.stream.Collectors.toList());
    }

    @PostMapping("/grant-donor-reward")
    public void grantDonorReward(@RequestBody GrantDonorRewardRequest grantDonorRewardRequest) {
        this.grantDonorReward.grantDonorReward(grantDonorRewardRequest);
    }
}
