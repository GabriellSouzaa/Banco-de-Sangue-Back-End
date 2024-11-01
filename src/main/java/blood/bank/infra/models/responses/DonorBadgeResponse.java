package blood.bank.infra.models.responses;

import blood.bank.domain.entities.donorBadge.DonorBadge;

import java.time.LocalDate;

public class DonorBadgeResponse {

    private DonorResponse donor;

    private BadgeResponse badge;

    private LocalDate achievementDate;

    public DonorBadgeResponse(DonorBadge donorBadge){
        this.donor = new DonorResponse(donorBadge.getDonor());
        this.badge = new BadgeResponse(donorBadge.getBadge());
        this.achievementDate = donorBadge.getAchievementDate();
    }

    public DonorResponse getDonor() {
        return donor;
    }

    public void setDonor(DonorResponse donor) {
        this.donor = donor;
    }

    public BadgeResponse getBadge() {
        return badge;
    }

    public void setBadge(BadgeResponse badge) {
        this.badge = badge;
    }

    public LocalDate getAchievementDate() {
        return achievementDate;
    }

    public void setAchievementDate(LocalDate achievementDate) {
        this.achievementDate = achievementDate;
    }
}
