package blood.bank.application.gateways;

import blood.bank.domain.entities.reward.Reward;

import java.util.List;

public interface RewardRepositoryGateway {

    List<Reward> getRewards();
}
