package blood.bank.infra.persistence.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "doador_insignia")
public class DonorBadgeEntity {

    @EmbeddedId
    private DonorBadgeId donorBadgeId;

    @ManyToOne
    @MapsId("donorId")
    @JoinColumn(name = "doador_id")
    private DonorEntity donor;

    @ManyToOne
    @MapsId("badgeId")
    @JoinColumn(name = "insignia_id")
    private BadgeEntity badgeEntity;

    @Column(name = "data_conquista")
    private LocalDate achievementDate;

    public DonorBadgeEntity() {
    }

    public DonorBadgeEntity(DonorEntity donor, BadgeEntity badgeEntity, LocalDate achievementDate) {
        this.donorBadgeId = new DonorBadgeId(donor.getId(), badgeEntity.getId());
        this.badgeEntity = badgeEntity;
        this.achievementDate = achievementDate;
    }

    public DonorBadgeId getDonorBadgeId() {
        return donorBadgeId;
    }

    public void setDonorBadgeId(DonorBadgeId donorBadgeId) {
        this.donorBadgeId = donorBadgeId;
    }

    public DonorEntity getDonor() {
        return donor;
    }

    public void setDonor(DonorEntity donor) {
        this.donor = donor;
    }

    public BadgeEntity getBadgeEntity() {
        return badgeEntity;
    }

    public void setBadgeEntity(BadgeEntity badgeEntity) {
        this.badgeEntity = badgeEntity;
    }

    public LocalDate getAchievementDate() {
        return achievementDate;
    }

    public void setAchievementDate(LocalDate achievementDate) {
        this.achievementDate = achievementDate;
    }
}
