package blood.bank.infra.controller;

import blood.bank.application.usecases.reward.CreateReward;
import blood.bank.application.usecases.reward.DeleteReward;
import blood.bank.application.usecases.reward.ListReward;
import blood.bank.application.usecases.reward.UpdateReward;
import blood.bank.domain.entities.reward.Reward;
import blood.bank.infra.models.requests.RewardRequest;
import blood.bank.infra.models.responses.RewardResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reward")
public class RewardController {

    private final ListReward listReward;

    private final CreateReward createReward;

    private final UpdateReward updateReward;

    private final DeleteReward deleteReward;

    public RewardController(ListReward listReward, CreateReward createReward, UpdateReward updateReward, DeleteReward deleteReward) {
        this.listReward = listReward;
        this.createReward = createReward;
        this.updateReward = updateReward;
        this.deleteReward = deleteReward;
    }

    @GetMapping
    List<RewardResponse> listReward(){
        List<Reward> rewards = listReward.getAllRewards();
        return rewards.stream().map(RewardResponse::new).collect(Collectors.toList());
    }

    @PostMapping
    void createReward(@RequestBody RewardRequest reward){
        createReward.createReward(reward);
    }

    @PutMapping("/{id}")
    void updateReward(@PathVariable Long id, @RequestBody RewardRequest reward){
        updateReward.updateReward(id, reward);
    }

    @DeleteMapping("/{id}")
    void deleteReward(@PathVariable Long id){
        deleteReward.deleteReward(id);
    }
}
