package blood.bank.infra.persistence.models;

import jakarta.persistence.*;

@Entity
@Table(name = "doador_has_desafio")
public class DonorChallengeEntity {

    @EmbeddedId
    private DonorChallengeId id;

    @ManyToOne
    @MapsId("donorId")
    @JoinColumn(name = "doador_id_doador")
    private DonorEntity donor;

    @ManyToOne
    @MapsId("challengeId")
    @JoinColumn(name = "desafio_id_desafio")
    private ChallengeEntity challenge;

    public DonorChallengeEntity() {

    }

    public DonorChallengeEntity(DonorEntity donor, ChallengeEntity challenge) {
        this.donor = donor;
        this.challenge = challenge;
        this.id = new DonorChallengeId(donor.getId(), challenge.getId());
    }

    public DonorChallengeId getId() {
        return id;
    }

    public void setId(DonorChallengeId id) {
        this.id = id;
    }

    public DonorEntity getDonor() {
        return donor;
    }

    public void setDonor(DonorEntity donor) {
        this.donor = donor;
    }

    public ChallengeEntity getChallenge() {
        return challenge;
    }

    public void setChallenge(ChallengeEntity challenge) {
        this.challenge = challenge;
    }
}
