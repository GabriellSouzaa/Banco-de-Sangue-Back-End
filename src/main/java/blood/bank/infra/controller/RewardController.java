package blood.bank.infra.controller;

import blood.bank.application.usecases.reward.ListReward;
import blood.bank.domain.entities.reward.Reward;
import blood.bank.infra.models.responses.RewardResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reward")
public class RewardController {

    private final ListReward listReward;

    public RewardController(ListReward listReward) {
        this.listReward = listReward;
    }

    @GetMapping
    List<RewardResponse> listReward(){
        List<Reward> rewards = listReward.getAllRewards();
        return rewards.stream().map(RewardResponse::new).collect(Collectors.toList());
    }
}
