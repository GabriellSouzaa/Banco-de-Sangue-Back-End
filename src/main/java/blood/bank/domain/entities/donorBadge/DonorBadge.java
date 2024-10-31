package blood.bank.domain.entities.donorBadge;

import blood.bank.domain.entities.badge.Badge;
import blood.bank.domain.entities.donor.Donor;

import java.time.LocalDate;

public class DonorBadge {

    private Donor donor;

    private Badge badge;

    private LocalDate achievementDate;

    public DonorBadge(Donor donor, Badge badge, LocalDate achievementDate) {
        this.donor = donor;
        this.badge = badge;
        this.achievementDate = achievementDate;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    public LocalDate getAchievementDate() {
        return achievementDate;
    }

    public void setAchievementDate(LocalDate achievementDate) {
        this.achievementDate = achievementDate;
    }
}
