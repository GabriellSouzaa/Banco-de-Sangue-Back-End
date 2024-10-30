package blood.bank.infra.controller;

import blood.bank.application.usecases.donorReward.ListDonorsRewardByDonorId;
import blood.bank.domain.entities.donorReward.DonorReward;
import blood.bank.infra.models.responses.DonorRewardResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/donor-reward")
@RestController
public class DonorRewardController {

    private final ListDonorsRewardByDonorId listDonorsRewardByDonorId;

    public DonorRewardController(ListDonorsRewardByDonorId listDonorsRewardByDonorId) {
        this.listDonorsRewardByDonorId = listDonorsRewardByDonorId;
    }

    @GetMapping("/donor/{donorId}")
    public List<DonorRewardResponse> getDonorRewardByDonorId(@PathVariable Long donorId) {
        List<DonorReward> donorRewards = listDonorsRewardByDonorId.getDonorsRewardByDonorId(donorId);
        return donorRewards.stream().map(DonorRewardResponse::new).collect(java.util.stream.Collectors.toList());
    }
}
