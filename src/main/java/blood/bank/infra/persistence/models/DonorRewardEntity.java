package blood.bank.infra.persistence.models;

import jakarta.persistence.*;

@Entity
@Table(name = "doador_has_recompensa")
public class DonorRewardEntity {

    @EmbeddedId
    private DonorRewardId id;

    @ManyToOne
    @MapsId("donorId")
    @JoinColumn(name = "doador_id_doador")
    private DonorEntity donor;

    @ManyToOne
    @MapsId("rewardId")
    @JoinColumn(name = "recompensa_id_recompensa")
    private RewardEntity reward;

    public DonorRewardEntity() {

    }

    public DonorRewardEntity(DonorEntity donor, RewardEntity reward) {
        this.donor = donor;
        this.reward = reward;
        this.id = new DonorRewardId(donor.getId(), reward.getId());
    }

    public DonorRewardId getId() {
        return id;
    }

    public void setId(DonorRewardId id) {
        this.id = id;
    }

    public DonorEntity getDonor() {
        return donor;
    }

    public void setDonor(DonorEntity donor) {
        this.donor = donor;
    }

    public RewardEntity getReward() {
        return reward;
    }

    public void setReward(RewardEntity reward) {
        this.reward = reward;
    }
}
